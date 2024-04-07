package org.example;

import com.mongodb.client.*;
import org.bson.Document;

public class Database {
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> tweets;
    MongoCollection<Document> post;
    // connect to mongodb
    public Database() {
        client = MongoClients.create("mongodb://localhost:27017");
        database = client.getDatabase("cs622");
        database.createCollection("tweets");
        //Tweet posts
        database.createCollection("postTweets");
    }

    public Document InsertDocument(String collection, String key, Object value) {
        MongoCollection<Document> dbCollection = database.getCollection(collection);
        Document document = new Document();
        document.put(key, value);
        dbCollection.insertOne(document);
        return document;
    }

    public void findAll(String collection, Document document) {
        MongoCollection<Document> dbCollection = database.getCollection(collection);
        FindIterable<Document> cursor = dbCollection.find(document);

        try (final MongoCursor<Document> cursorIterator = cursor.cursor()) {
            while (cursorIterator.hasNext()) {
                System.out.println(cursorIterator.next());
            }
        }
    }
}
