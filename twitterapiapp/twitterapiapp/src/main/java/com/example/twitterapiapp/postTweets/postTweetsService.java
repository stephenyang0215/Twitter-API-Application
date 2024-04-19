package com.example.twitterapiapp.postTweets;
import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.twitter.clientlib.model.Get2UsersMeResponse;
import org.bson.Document;
import org.example.Database;
import org.example.findMyUser;
import org.example.postTweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class postTweetsService {
    @Autowired
    postTweetsRepository postTweetsRepository;
    public List<postTweetsSpring> getAllTweets() {
        return postTweetsRepository.findAll();
    }

    public postTweetsSpring getTweetsById(String id) {
        postTweetsSpring Tweets = postTweetsRepository.getTweetsById(id);
        return Tweets;
    }

    public postTweetsSpring addTweets(String tweets, String accessToken) {
        postTweetsSpring Tweets = new postTweetsSpring();
        postTweet postTweet = new postTweet();
        String result = postTweet.postTweet(tweets, accessToken);
        Tweets.setId("1");
        Tweets.setTweets(result);
        return postTweetsRepository.save(Tweets);
    }

    public Get2UsersMeResponse findMyUser(String accessToken) {
        findMyUser me = new findMyUser(accessToken);
        return me.display();
    }
/*
    public String findAllTweets() {
        Database db = new Database();
        MongoCollection<Document> dbCollection = db.getPostTweets();
        FindIterable<Document> cursor = dbCollection.find();
        MongoCursor<Document> cursorIterator = cursor.cursor();


        //try (final MongoCursor<Document> cursorIterator = cursor.cursor()) {
        //    while (cursorIterator.hasNext()) {
        //        System.out.println(cursorIterator.next().toString());
        //    }
        //}
        return cursorIterator.next().toString();
    }

 */
}
