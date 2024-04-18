package org.example;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;
import org.bson.Document;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // configure to show only error logs for db
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.ERROR);

        // testing for adding a data in
        Database db = new Database();
        new postTweet(db);
        MongoIterable<Document> iterable0 = db.postTweets.find();
        System.out.println(iterable0.first());
        /*
         * MongoIterable<Document> iterable1 = db.bookmarksLookup.find();
         * System.out.println(iterable1.first());
         * MongoIterable<Document> iterable2 = db.recentSearch.find();
         * System.out.println(iterable2.first());
         * MongoIterable<Document> iterable3 = db.timelines.find();
         * System.out.println(iterable3.first());
         * MongoIterable<Document> iterable4 = db.tweetsLookup.find();
         * System.out.println(iterable4.first());
         * 
         */

    }
}