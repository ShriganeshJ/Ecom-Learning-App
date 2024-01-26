package com.ecom.mongo;

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
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;
@Repository
public class TopGainer {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    MongoClient mongoClient;


    public  MongoCursor<Document> getDataFromMongoDb()
    {
        MongoCollection<Document> mongoCollection= mongoClient.getDatabase("ECOM").getCollection("Currnecny");
        var it =mongoCollection.aggregate(BsonArray.parse(TopGainerLooser.TOP_GAINER)
                .stream()
                .map(bsonValue -> bsonToDocument(bsonValue.asDocument()))
                .collect(Collectors.toList()));
                 return it.iterator();
    }


    public Document bsonToDocument(BsonDocument bsonDocument)
    {
        DocumentCodec codec = new DocumentCodec();
        DecoderContext decoderContext = DecoderContext.builder().build();
        return codec.decode(new BsonDocumentReader(bsonDocument),decoderContext);
    }
}
