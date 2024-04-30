/*
    Class: postTweet
    Description: post the Tweets by the application
 */
package org.example;
import java.util.*;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.model.*;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TwitterApi;
import org.bson.Document;

public class postTweet {
    TweetCreateResponse response;

    private List<Document> generateMongoDocs(List<String> lines) {
        List<Document> docs = new ArrayList<>();
        for (String json : lines) {
            docs.add(Document.parse(json));
        }
        return docs;
    }

    public postTweet(Database db) {
        OAuth20GetAccessToken OAuth20 = new OAuth20GetAccessToken();
        TwitterCredentialsOAuth2 credentials = OAuth20.getCredentials();
        //Connect to Twitter server
        TwitterApi api = new TwitterApi(credentials);
        // Set the params values
        TweetCreateRequest tweetCreateRequest = new TweetCreateRequest();
        try {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Write the content for your tweet:");
            String tweets = myObj.nextLine();  // Read user input
            System.out.println("The content is: " + tweets);  // Output user input
            response = api.tweets().createTweet(tweetCreateRequest.text(tweets))
                    .execute();
            System.out.println(response);
            Document document = db.InsertDocument("postTweets","Tweets", response.toJson());
            db.findAll("postTweets", document);
            System.out.println("Successfully write record to the database!");

        } catch (ApiException e) {
            System.err.println("Exception when calling TweetsApi#createTweet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
    //Trigger the post Tweets endpoints
    public postTweet(String tweets, String accessToken) {
        TwitterCredentialsOAuth2 credentials = new TwitterCredentialsOAuth2(
                System.getenv("TWITTER_OAUTH2_CLIENT_ID"),
                System.getenv("TWITTER_OAUTH2_CLIENT_SECRET"),
                accessToken,
                System.getenv("TWITTER_OAUTH2_REFRESH_TOKEN"));
        //post twitter
        TwitterApi api = new TwitterApi(credentials);
        // Set the params values
        TweetCreateRequest tweetCreateRequest = new TweetCreateRequest();
        try {
            System.out.println("The content is: " + tweets);  // Output user input
            response = api.tweets().createTweet(tweetCreateRequest.text(tweets))
                    .execute();
            //System.out.println(result);
            //Document document = db.InsertDocument("postTweets","Tweets", tweets);
            //Document document = db.InsertDocument("postTweets","Tweets", result.toJson());
            //db.findAll("postTweets", document);
            //System.out.println("Successfully write record to the database!");

        } catch (ApiException e) {
            System.err.println("Exception when calling TweetsApi#createTweet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    public TweetCreateResponse getResponse() {
        return response;
    }
}
