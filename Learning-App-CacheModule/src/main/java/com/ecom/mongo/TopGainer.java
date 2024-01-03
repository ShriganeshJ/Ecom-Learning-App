package com.ecom.mongo;

import com.ecom.query.CurrencyData;
import com.ecom.query.TopGainerLooser;
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
public class TopGainer {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    MongoClient mongoClient;


    public void getDataFromMongoDb()
    {
        MongoCollection<Document> mongoCollection= mongoClient.getDatabase("ECOM").getCollection("Currnecny");
        var it =mongoCollection.aggregate(BsonArray.parse(TopGainerLooser.TOP_GAINER)
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

        }

    }

    public Document bsonToDocument(BsonDocument bsonDocument)
    {
        DocumentCodec codec = new DocumentCodec();
        DecoderContext decoderContext = DecoderContext.builder().build();
        return codec.decode(new BsonDocumentReader(bsonDocument),decoderContext);
    }
}
