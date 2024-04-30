/*
    Class: findMyUser
    Description: Identify the Twitter account the application is on behalf of
 */
package org.example;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.model.*;
import com.twitter.clientlib.api.TwitterApi;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class findMyUser {
    TwitterApi api;
    Set<String> userFields;
    Set<String> expansions;
    Set<String> tweetFields;
    public findMyUser(String accessToken) {
        TwitterCredentialsOAuth2 credentials = new TwitterCredentialsOAuth2(
                System.getenv("TWITTER_OAUTH2_CLIENT_ID"),
                System.getenv("TWITTER_OAUTH2_CLIENT_SECRET"),
                accessToken,
                System.getenv("TWITTER_OAUTH2_REFRESH_TOKEN"));
        //connect to twitter server
        api = new TwitterApi(credentials);
        //generic collections for cached user data
        userFields = new HashSet<>(Arrays.asList());
        expansions = new HashSet<>(Arrays.asList());
        tweetFields = new HashSet<>(Arrays.asList());

    }
    //Trigger the find-my-user endpoint
    public Get2UsersMeResponse display() {
        Get2UsersMeResponse result = null;
        try {
            result = api.users().findMyUser()
                    .userFields(userFields)
                    .expansions(expansions)
                    .tweetFields(tweetFields)
                    .execute();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#findMyUser");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
        return result;
    }
}
