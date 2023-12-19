package com.ecom.gemfre;

import com.ecom.pojo.AccountDataResponse;
import com.ecom.query.AccountData;
import com.ecom.repo.AccountRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonDocumentReader;
import org.bson.Document;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LoadData {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    MongoClient mongoClient;

    public AccountDataResponse getResponseById(String id)
    {
        System.out.println("accountRepository Object Class Name "+accountRepository.getClass().getName());
        return accountRepository.findById(id).get();
    }

    public void getFromMongoClient()
    {
      MongoCollection<Document> mongoCollection= mongoClient.getDatabase("ECOM").getCollection("SDVS");
       var it =mongoCollection.aggregate(BsonArray.parse(AccountData.GET_PULSE_USER_QUERY)
               .stream()
               .map(bsonValue -> bsonToDocument(bsonValue.asDocument()))
               .collect(Collectors.toList()));
       //send data to cahce
        insertIntoCache(it.iterator());



    }
    public  void insertIntoCache(MongoCursor<Document> mongoCursor)
    {
        var counter =0;
        while (mongoCursor.hasNext())
        {
            counter++;
            var document = mongoCursor.next();
            var session =document.get("session",String.class);
            var platform = document.get("platform", String.class);
           // var userInfo=document.get("userInfo", UserInfo.class);
            System.out.println("session::"+session+"Platform::"+platform);
        }

    }

public Document bsonToDocument(BsonDocument bsonDocument)
{
    DocumentCodec codec = new DocumentCodec();
    DecoderContext decoderContext = DecoderContext.builder().build();
    return codec.decode(new BsonDocumentReader(bsonDocument),decoderContext);
}


}

