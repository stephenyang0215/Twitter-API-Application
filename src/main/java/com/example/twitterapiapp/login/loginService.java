package com.example.twitterapiapp.login;

import com.example.twitterapiapp.postTweets.postTweetsRepository;
import com.example.twitterapiapp.postTweets.postTweetsSpring;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.TweetCreateRequest;
import org.example.OAuth20GetAccessToken;
import org.example.postTweet;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class loginService {
    @Autowired
    loginRepository loginRepository;

    public String Oauth2() {
        OAuth20GetAccessToken OAuth20 = new OAuth20GetAccessToken();
        TwitterCredentialsOAuth2 credentials = OAuth20.getCredentials();
        return credentials.getTwitterOauth2AccessToken();
    }
}
