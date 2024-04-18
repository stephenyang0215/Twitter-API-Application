package org.example;
import java.util.Scanner;  // Import the Scanner class
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.model.*;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TwitterApi;
import org.bson.Document;

public class postTweet {
    public postTweet(Database db) {
        OAuth20GetAccessToken OAuth20 = new OAuth20GetAccessToken();
        TwitterCredentialsOAuth2 credentials = OAuth20.getCredentials();
        //post twitter
        TwitterApi api = new TwitterApi(credentials);
        // Set the params values
        TweetCreateRequest tweetCreateRequest = new TweetCreateRequest();
        try {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Write the content for your tweet:");
            String tweets = myObj.nextLine();  // Read user input
            System.out.println("The content is: " + tweets);  // Output user input
            TweetCreateResponse result = api.tweets().createTweet(tweetCreateRequest.text(tweets))
                    .execute();
            System.out.println(result);
            Document document = db.InsertDocument("postTweets","Tweets", tweets);
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
}
