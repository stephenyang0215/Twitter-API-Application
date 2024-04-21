package org.example;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.example.Database;
import org.example.TweetsLookup;
import org.example.findMyUser;
import org.example.postTweet;
import org.slf4j.*;
import org.bson.Document;

public class Main {
    public static void main(String[] args) throws OAuthSystemException, OAuthProblemException {
        // configure to show only error logs for db
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.ERROR);

        // testing for adding a data in
        Database db = new Database();
        TweetsLookup tu = new TweetsLookup();

        // Run scripts in the Docker Container:
        // Backup plan for posting tweets
        // Arguments:
        // tweets: Tweet Content
        // accessToken: Access Token for OAuth2 from Postman
        // db: Instance of MongoDB
        String tweets = "hello world! this is the tweets from my java!!!!!!!!!!!!!";
        String accessToken = "WlVHZXFSbXV6OTl3RHQ0Qm0ybk0waEU2MjhqekJzcmdfZGtwWjRobWV2VnFxOjE3MTM0ODE5MTkwNzg6MToxOmF0OjE";
        // function1: Post new Tweets
        //new postTweet(tweets, accessToken);
        System.out.println("Successfully write record to the database!");

        // function2: Display your Twitter user ID
        findMyUser me = new findMyUser(accessToken);
        me.display();

        // function3: Delete Tweets by ID
        // new deleteTweetById(accessToken, "1780754482315644964", db);

        // System.out.println("From Main-----------------");
        // System.out.println(db.lookUp("tweetsLookup", 1));
        // tu.parsing(1);

        /*
         * Run scripts locally
         * It requires to authorize the request for access token on the Twitter page.
         * Copy the code from the redirect url and paste it on the compile
         */
        // new postTweet(db);
        // MongoIterable<Document> iterable0 = db.postTweets.find();
        // System.out.println(iterable0.first());

    }
}