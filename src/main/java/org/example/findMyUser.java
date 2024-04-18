package org.example;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.model.*;
import com.twitter.clientlib.api.TwitterApi;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class findMyUser {
    public findMyUser(String accessToken, Database db) {
        TwitterCredentialsOAuth2 credentials = new TwitterCredentialsOAuth2(
                "d0kzQnBOcDl3Y3RfUXhVcHVha3Q6MTpjaQ",
                "C105RUOmrd6zOth8BCD3TbWUj4KlfxXxEIjCGJYBM6tO59JB-a",
                accessToken,
                "https://api.twitter.com/2/oauth2/token");
        //post twitter
        TwitterApi api = new TwitterApi(credentials);

        // Set the params values
        Set<String> userFields = new HashSet<>(Arrays.asList()); // Set<String> | A comma separated list of User fields to display.
        Set<String> expansions = new HashSet<>(Arrays.asList()); // Set<String> | A comma separated list of fields to expand.
        Set<String> tweetFields = new HashSet<>(Arrays.asList()); // Set<String> | A comma separated list of Tweet fields to display.
        try {
            Get2UsersMeResponse result = api.users().findMyUser()
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
    }
}
