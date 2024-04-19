package com.example.twitterapiapp.postTweets;
import com.twitter.clientlib.model.Get2UsersMeResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface postTweetsRepository extends MongoRepository<postTweetsSpring,String> {
    // Need to add all the required methods here
    postTweetsSpring findTweetsById(String id);
    //findMyUserSpring getMe(String accessToken);
}
