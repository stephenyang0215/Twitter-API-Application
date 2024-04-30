/*
    Class: deleteTweetById
    Description: Delete the tweets generated from post tweets endpoint
 */
package org.example;
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.model.*;
import com.twitter.clientlib.api.TwitterApi;

public class deleteTweetById {
    public deleteTweetById(String accessToken, String id) {
        TwitterCredentialsOAuth2 credentials = new TwitterCredentialsOAuth2(
                System.getenv("TWITTER_OAUTH2_CLIENT_ID"),
                System.getenv("TWITTER_OAUTH2_CLIENT_SECRET"),
                accessToken,
                System.getenv("TWITTER_OAUTH2_REFRESH_TOKEN"));
        //connect to twitter server
        TwitterApi api = new TwitterApi(credentials);

        try {
            TweetDeleteResponse result = api.tweets().deleteTweetById(id)
                    .execute();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TweetsApi#deleteTweetById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}