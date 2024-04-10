package org.example;
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.TweetCreateRequest;
import com.twitter.clientlib.model.TweetCreateResponse;
import org.bson.Document;

import javax.xml.crypto.Data;

public class test {
    public test(String tweets, String accessToken, Database db) {
        TwitterCredentialsOAuth2 credentials = new TwitterCredentialsOAuth2(
                "d0kzQnBOcDl3Y3RfUXhVcHVha3Q6MTpjaQ",
                "C105RUOmrd6zOth8BCD3TbWUj4KlfxXxEIjCGJYBM6tO59JB-a",
                accessToken,
                "https://api.twitter.com/2/oauth2/token");
        //post twitter
        TwitterApi api = new TwitterApi(credentials);
        // Set the params values
        TweetCreateRequest tweetCreateRequest = new TweetCreateRequest();
        try {
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
