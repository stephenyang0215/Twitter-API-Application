package org.example;

import com.mongodb.*;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.*;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        //host machine connection to database: if your container is running locally: brew services start mongodb-community@7.0
        //String uri = "mongodb://root:password@localhost:27017";
        //container connection to database
        String uri = "mongodb://root:password@mongodb:27017";
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
        database = mongoClient.getDatabase("test");
        // Send a ping to confirm a successful connection
        Bson command = new BsonDocument("ping", new BsonInt64(1));
        Document commandResult = database.runCommand(command);
        System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        //Tweet posts
        postTweets = database.getCollection("postTweets");
        bookmarksLookup = database.getCollection("bookmarksLookup");
        //Retrieving the documents
        MongoIterable<Document> iterable0 = bookmarksLookup.find();
        System.out.println(iterable0.first());
        //importJson("bookmarksLookup", "data/Bookmarks-Lookup.json");
        recentSearch = database.getCollection("recentSearch");
        MongoIterable<Document> iterable1 = recentSearch.find();
        System.out.println(iterable1.first());
        //importJson("bookmarksLookup", "data/Recent-Search.json");
        timelines = database.getCollection("timelines");
        MongoIterable<Document> iterable2 = timelines.find();
        System.out.println(iterable2.first());
        //importJson("timelines", "data/Timelines.json");
        tweetsLookup = database.getCollection("tweetsLookup");
        MongoIterable<Document> iterable3 = tweetsLookup.find();
        System.out.println(iterable3.first());
        //importJson("tweetsLookup", "data/Tweets-Lookup.json");
    }

    public Document InsertDocument(String collection, String key, Object value) {
        MongoCollection<Document> dbCollection = database.getCollection(collection);
        Document document = new Document();
        document.put(key, value);
        dbCollection.insertOne(document);
        return document;
    }

    public void importJson(String collection, String filePath) {
        //Material: https://www.mongodb.com/compatibility/json-to-mongodb
        MongoCollection<org.bson.Document> coll = database.getCollection(collection);

        try {

            //drop previous import
            coll.drop();

            //Bulk Approach:
            int count = 0;
            int batch = 100;
            List<InsertOneModel<Document>> docs = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    docs.add(new InsertOneModel<>(Document.parse(line)));
                    count++;
                    if (count == batch) {
                        coll.bulkWrite(docs, new BulkWriteOptions().ordered(false));
                        docs.clear();
                        count = 0;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (count > 0) {
                BulkWriteResult bulkWriteResult = coll.bulkWrite(docs, new BulkWriteOptions().ordered(false));
                System.out.println("Inserted" + bulkWriteResult);
            }

        } catch (MongoWriteException e) {
            System.out.println("Error");
        }

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