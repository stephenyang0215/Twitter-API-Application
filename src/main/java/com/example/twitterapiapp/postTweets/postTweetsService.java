/*
    Class: postTweetsService
    Description: Building service for the posting Tweets endpoints
 */
package com.example.twitterapiapp.postTweets;
import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.twitter.clientlib.model.Get2UsersMeResponse;
import com.twitter.clientlib.model.TweetCreateResponse;
import org.bson.Document;
import org.example.Database;
import org.example.deleteTweetById;
import org.example.findMyUser;
import org.example.postTweet;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class postTweetsService {
    @Autowired
    postTweetsRepository postTweetsRepository;
    public List<postTweetsSpring> getAllTweets() {
        return postTweetsRepository.findAll();
    }

    public postTweetsSpring getByTweetsId(String id) {
        postTweetsSpring Tweets = postTweetsRepository.findTweetsById(id);
        return Tweets;
    }

    public postTweetsSpring addTweets(String tweets, String accessToken) {
        postTweetsSpring Tweets = new postTweetsSpring();
        postTweet postTweet = new postTweet(tweets, accessToken);
        JSONObject obj = new JSONObject(postTweet.getResponse().toJson());
        Tweets.setId(obj.getJSONObject("data").getString("id"));
        Tweets.setTweets(obj.getJSONObject("data").getString("text"));
        return postTweetsRepository.save(Tweets);
    }

    public Get2UsersMeResponse findMyUser(String accessToken) {
        findMyUser me = new findMyUser(accessToken);
        return me.display();
    }

    public void removeTweets(String accessToken, String id) {
        postTweetsSpring Tweets = new postTweetsSpring();
        Tweets.setId(id);
        new deleteTweetById(accessToken, id);
        postTweetsRepository.delete(Tweets);
    }
}
