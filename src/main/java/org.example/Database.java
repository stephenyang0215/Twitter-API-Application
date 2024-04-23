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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> postTweets;
    MongoCollection<Document> bookmarksLookup;
    MongoCollection<Document> recentSearch;
    MongoCollection<Document> timelines;
    MongoCollection<Document> tweetsLookup;

    Document document = new Document();

    // connect to mongodb
    public Database() {
        // host machine connection to database: if your container is running locally:
        // brew services start mongodb-community@7.0
        // String uri = "mongodb://localhost:27017";
        // container connection to database
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
        // Tweet posts
        postTweets = database.getCollection("postTweets");
        bookmarksLookup = database.getCollection("bookmarksLookup");
        // Retrieving the documents
        // MongoIterable<Document> iterable0 = bookmarksLookup.find();
        // System.out.println(iterable0.first());
        // importJson("bookmarksLookup", "data/Bookmarks-Lookup.json");
        recentSearch = database.getCollection("recentSearch");
        // MongoIterable<Document> iterable1 = recentSearch.find();
        // System.out.println(iterable1.first());
        // importJson("bookmarksLookup", "data/Recent-Search.json");
        timelines = database.getCollection("timelines");
        // MongoIterable<Document> iterable2 = timelines.find();
        // System.out.println(iterable2.first());
        // importJson("timelines", "data/Timelines.json");
        tweetsLookup = database.getCollection("tweetsLookup");
        // MongoIterable<Document> iterable3 = tweetsLookup.find();
        // if (iterable3.first() == null){
        // String filePath = "data/Tweets-Lookup.json";
        // addTweets_LookuptoDB("tweetsLookup", filePath);
        // }
        // System.out.println(iterable3.first());
        // importJson("tweetsLookup", "data/Tweets-Lookup.json");
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

    // lookup tweets
    public Document lookUp(String collection, int id) {
        MongoCollection<Document> dbCollection = database.getCollection(collection);
        List<Document> records = dbCollection.find().first().getList("records", Document.class);

        for (Document record : records) {
            Integer record_id = record.getInteger("_id");
            if (record_id.equals(id)) {
                return record;
            }
        }
        return null;
    }

    // add tweets to db
    public void addTweets_LookuptoDB(String collection, String filePath) {
        try {
            // parsing json file
            Object parse = new JSONParser().parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) parse;
            JSONArray tweets = (JSONArray) jsonObject.get("records");
            for (Object file_tweet : tweets) {
                // when search it gets by index not id so -1
                JSONObject retrieve = (JSONObject) file_tweet;

                // get the values from json object
                Long userid = (Long) retrieve.get("_id");
                String account = (String) retrieve.get("account");
                String tweet = (String) retrieve.get("tweet");
                String url = (String) retrieve.get("url");

                JSONArray hashtag = (JSONArray) retrieve.get("hashtag");

                JSONArray search = (JSONArray) retrieve.get("search");

                JSONObject share_tweet = (JSONObject) retrieve.get("share_tweet");

                String share_url = (String) retrieve.get("share_url");
                String time = (String) retrieve.get("time");
                Long views = (Long) retrieve.get("views");

                MongoCollection<Document> dbCollection = database.getCollection(collection);
                document.put("_id", userid);
                document.put("account", account);
                document.put("tweet", tweet);
                document.put("url", url);
                document.put("hashtag", hashtag);
                document.put("search", search);
                document.put("share_tweet", share_tweet);
                document.put("share_url", share_url);
                document.put("time", time);
                document.put("views", views);
                dbCollection.insertOne(document);
            }

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public MongoCollection<Document> getPostTweets() {
        return postTweets;
    }
}