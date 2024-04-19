package com.example.twitterapiapp.postTweets;
import java.util.List;
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
        postTweetsSpring Tweets = postTweetsRepository.findByPostTweetsId(id);
        return Tweets;
    }

    public postTweetsSpring addTweets(String tweets) {
        postTweetsSpring Tweets = new postTweetsSpring();
        Tweets.setId("1");
        Tweets.setTweets(tweets);
        return postTweetsRepository.save(Tweets);
    }
}
