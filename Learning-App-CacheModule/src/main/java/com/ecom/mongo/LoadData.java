package com.ecom.mongo;

import com.ecom.pojo.TradeInfo;
import com.ecom.pojo.UserInfo;
import com.ecom.query.CurrencyData;
import com.ecom.repo.AccountRepository;
import com.google.gson.Gson;
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

    public void getDataFromMongoDb()
    {
      MongoCollection<Document> mongoCollection= mongoClient.getDatabase("ECOM").getCollection("SDVS");
       var it =mongoCollection.aggregate(BsonArray.parse(CurrencyData.CONDITION_AGG)
               .stream()
               .map(bsonValue -> bsonToDocument(bsonValue.asDocument()))
               .collect(Collectors.toList()));

        insertIntoCache(it.iterator());



    }
    public  void insertIntoCache(MongoCursor<Document> mongoCursor)
    {
        var counter =0;
        Gson gson = new Gson();
        while (mongoCursor.hasNext())
        {

    System.out.println(mongoCursor.next().toJson());
          /*  counter++;
            var document = mongoCursor.next();
            var k1Number =document.get("k1_Number",String.class);
            var session =document.get("session",String.class);
            var exchange =document.get("Exchange",String.class);
            var userInfo = gson.fromJson(document.get("userInfo", Document.class).toJson(), UserInfo.class);
            var tradeInfo =gson.fromJson(document.get("tradeInfo", Document.class).toJson(), TradeInfo.class);

            System.out.println("K1Number::"+k1Number+"Session::"+session+"Exchange::"+exchange);
           System.out.println("UserInfo::"+userInfo);
           System.out.println("TradeInfo::"+tradeInfo);*/
        }

    }

public Document bsonToDocument(BsonDocument bsonDocument)
{
    DocumentCodec codec = new DocumentCodec();
    DecoderContext decoderContext = DecoderContext.builder().build();
    return codec.decode(new BsonDocumentReader(bsonDocument),decoderContext);
}


}

