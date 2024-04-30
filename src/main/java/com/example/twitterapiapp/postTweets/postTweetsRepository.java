/*
    Class: postTweetsRepository
    Description: Building repository for the postTweets endpoints
 */
package com.example.twitterapiapp.postTweets;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface postTweetsRepository extends MongoRepository<postTweetsSpring,String> {
    // Need to add all the required methods here
    postTweetsSpring findTweetsById(String id);
}
