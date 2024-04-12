package org.example;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.slf4j.*;
import org.bson.Document;

public class Main {
    public static void main(String[] args) throws OAuthSystemException, OAuthProblemException {
        // configure to show only error logs for db
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.ERROR);

        //testing for adding a data in
        Database db = new Database();

        //Run scripts in the Docker Container:
        //Backup plan for posting tweets
        //Arguments:
        // tweets: Tweet Content
        // accessToken: Access Token for OAuth2 from Postman
        // db: Instance of MongoDB
        String tweets = "hello world! this is the tweets from my java app running in the container!";
        String accessToken = "d3VuWC0tUzNUTVJmOE1fb1V4Q09oV2JIbldpbzloZ3owaFlpejhrN3o0cmloOjE3MTI4OTE3NTQzNjM6MToxOmF0OjE";
        new postTweet(tweets, accessToken, db);
        Document document = db.InsertDocument("postTweets","Tweets", tweets);
        db.findAll("postTweets", document);
        System.out.println("Successfully write record to the database!");


        /*
            Run scripts locally
            It requires to authorize the request for access token on the Twitter page.
            Copy the code from the redirect url and paste it on the compile
         */
        //new postTweet(db);
        //MongoIterable<Document> iterable0 = db.postTweets.find();
        //System.out.println(iterable0.first());
    }
}