package com.example.twitterapiapp.BookmarksLookup;
import com.example.twitterapiapp.postTweets.postTweetsSpring;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface bookmarksLookupRepository extends MongoRepository<bookmarksLookupSpring,String> {

}
