/*
    Class: Database
    Description: Building MongoDB database for the application
 */
package org.example;

import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database {
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> postTweets;
    MongoCollection<Document> bookmarksLookup;
    MongoCollection<Document> recentSearch;
    MongoCollection<Document> timelines;
    MongoCollection<Document> tweetsLookup;
    MongoCollection<Document> allData;
    Document document = new Document();

    // build out the instance for mongodb and connect to the database
    public Database() {
        // host machine connection to database: if your container is running locally:
        // brew services start mongodb-community@7.0
         String uri = "mongodb://root:password@localhost:27017";
        // container connection to database
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
         MongoIterable<Document> iterable1 = recentSearch.find();
        // System.out.println(iterable1.first());
        // importJson("bookmarksLookup", "data/Recent-Search.json");
        timelines = database.getCollection("timelines");
        // MongoIterable<Document> iterable2 = timelines.find();
        // System.out.println(iterable2.first());
        // importJson("timelines", "data/Timelines.json");
        tweetsLookup = database.getCollection("tweetsLookup");
//         MongoIterable<Document> iterable3 = tweetsLookup.find();
//         if (iterable3.first() == null){
//         String filePath = "data/Tweets-Lookup.json";
//         addTweets_LookuptoDB("tweetsLookup", filePath);
//         }
//         System.out.println(iterable3.first());
        // importJson("tweetsLookup", "data/Tweets-Lookup.json");
        allData = database.getCollection("allData");
//        MongoIterable<Document> iterable4 = allData.find();
//        if (iterable4.first() == null) {
//            String filePath = "data/AllData.json";
//            addTweets_LookuptoDB("allData", filePath);
//        }
//         System.out.println(iterable4.first());

    }
    //add document to the collection
    public Document InsertDocument(String collection, String key, Object value) {
        MongoCollection<Document> dbCollection = database.getCollection(collection);
        Document document = new Document();
        document.put(key, value);
        dbCollection.insertOne(document);
        return document;
    }
    //list all the documents for the collection specified
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
    public List<Document> lookUp(String collection, String keyword) {
        MongoCollection<Document> dbCollection = database.getCollection(collection);
        List<Document> records = dbCollection.find().first().getList("records", Document.class);

        List<Document> tweet_record = new ArrayList<Document>();

        Pattern pattern = Pattern.compile("\\b"+keyword+"\\b", Pattern.UNICODE_CASE);

        for (Document record : records) {
            String record_tweet = record.getString("tweet");
            Matcher tweet = pattern.matcher(record_tweet);
            if (tweet.find()){
                 tweet_record.add(record);
            }
        }
        return tweet_record;
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