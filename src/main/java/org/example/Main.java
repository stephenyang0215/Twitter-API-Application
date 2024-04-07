package org.example;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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
        new postTweet();
        /*
        //testing for adding a data in
        Database db = new Database();
        Document document = db.InsertDocument(
                "postTweets","Tweets", "Hello World From Java app");

        //Read a Document From a Collection
        db.findAll("postTweets", document);*/

    }
}