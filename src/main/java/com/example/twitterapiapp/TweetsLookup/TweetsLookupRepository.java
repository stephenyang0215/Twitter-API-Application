package com.example.twitterapiapp.TweetsLookup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TweetsLookupRepository extends MongoRepository<TweetsLookupSpring, String> {

//    List<TweetsLookupSpring> findByKeyword(String keyword);
}
