package org.example;

import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Database {
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> postTweets;
    MongoCollection<Document> bookmarksLookup;
    MongoCollection<Document> recentSearch;
    MongoCollection<Document> timelines;
    MongoCollection<Document> tweetsLookup;

    // connect to mongodb
    public Database() {
        //client = MongoClients.create("mongodb://localhost:27017");
        //database = client.getDatabase("cs622");

        //host machine connection to database: if your container is running locally: brew services start mongodb-community@7.0
        String uri = "mongodb://root:password@localhost:27017";
        //container connection to database
        //String uri = "mongodb://root:password@mongodb:27017";
        // Construct a ServerApi instance using the ServerApi.builder() method
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .strict(true)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server
        MongoClient mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("db");
        // Send a ping to confirm a successful connection
        Bson command = new BsonDocument("ping", new BsonInt64(1));
        Document commandResult = database.runCommand(command);
        System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        //Tweet posts
        postTweets = database.getCollection("postTweets");
        bookmarksLookup = database.getCollection("bookmarksLookup");
        recentSearch = database.getCollection("recentSearch");
        timelines = database.getCollection("timelines");
        tweetsLookup = database.getCollection("tweetsLookup");
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
