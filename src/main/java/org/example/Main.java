package org.example;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        // configure to show only error logs for db
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.ERROR);

        //testing for adding a data in
        Database db = new Database();
        Document document = new Document("id", "1").append("name", "John");
        db.collection.insertOne(document);
    }
}