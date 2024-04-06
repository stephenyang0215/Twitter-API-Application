package org.example;
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.model.*;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TwitterApi;

public class postTweet {
    public static void main(String[] args) {
        OAuth20GetAccessToken OAuth20 = new OAuth20GetAccessToken();
        TwitterCredentialsOAuth2 credentials = OAuth20.getCredentials();
        //post twitter
        TwitterApi api = new TwitterApi(credentials);
        // Set the params values
        TweetCreateRequest tweetCreateRequest = new TweetCreateRequest();
        try {
            TweetCreateResponse result = api.tweets().createTweet(tweetCreateRequest.text("Hello World From Java app"))
                    .execute();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TweetsApi#createTweet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
