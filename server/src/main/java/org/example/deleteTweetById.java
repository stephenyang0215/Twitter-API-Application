package org.example;
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.model.*;
import com.twitter.clientlib.api.TwitterApi;


public class deleteTweetById {
    public deleteTweetById(String accessToken, String id, Database db) {
        TwitterCredentialsOAuth2 credentials = new TwitterCredentialsOAuth2(
                "d0kzQnBOcDl3Y3RfUXhVcHVha3Q6MTpjaQ",
                "C105RUOmrd6zOth8BCD3TbWUj4KlfxXxEIjCGJYBM6tO59JB-a",
                accessToken,
                "https://api.twitter.com/2/oauth2/token");
        //post twitter
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