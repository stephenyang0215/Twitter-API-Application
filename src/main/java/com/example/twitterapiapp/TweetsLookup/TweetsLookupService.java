package com.example.twitterapiapp.TweetsLookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class TweetsLookupService {
    @Autowired
    TweetsLookupRepository tweetsLookupRepository;

//    public List<TweetsLookupSpring> getAllTweetsLookup(){
//    List<TweetsLookupSpring> tweets = new ArrayList<>();
//    List<Record> allRecords = tweetsLookupRepository.findAll();
//
//        for (Record record : allRecords) {
//            TweetsLookupSpring tweetSpring = new TweetsLookupSpring();
//            tweetSpring.setId(record.getId().toString()); // Assuming id is a String in Record
//            tweetSpring.setTweet(record.getTweet());
//            tweetSpring.setAccount(record.getAccount());
//            tweetSpring.setUrl(record.getUrl());
//            tweetSpring.setHashtag(record.getHashtag());
//            tweetSpring.setSearch(record.getSearch());
//            // ... Set other properties (shareUrl, time, views)
//            tweets.add(tweetSpring);
//        }
//
//        return tweets;}
    @GetMapping("/all")
    public List<TweetsLookupSpring> getAllTweetsLookup() {
        return tweetsLookupRepository.findAll();
    }
}
