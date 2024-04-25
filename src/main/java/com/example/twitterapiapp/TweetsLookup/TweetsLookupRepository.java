package com.example.twitterapiapp.TweetsLookup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TweetsLookupRepository extends MongoRepository<TweetsLookupSpring,String> {
    @Query("{'records.tweet' : { $regex: ?0, $options: 'i' } }")
    List<TweetsLookupSpring> findByTextPattern(String term);

}
