package com.example.twitterapiapp.AllData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AllDataService {

    @Autowired
    AllDataRepository allDataRepository;


    public List<AllDataSpring> getAllData() {
        return allDataRepository.findAll();
    }

    public List<AllDataSpring.Record> getTweetsByKeyword(String keyword) {
        List<AllDataSpring.Record> tweets = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*\\b" + keyword + ".*", Pattern.CASE_INSENSITIVE);
        for (AllDataSpring record : allDataRepository.findAll()) {
            for (AllDataSpring.Record tweet : record.getRecords()) {
                Matcher matching_tweet = pattern.matcher(tweet.getTweet());
                if (matching_tweet.find()) {
                    System.out.println(tweet.getTweet());
                    tweets.add(tweet);
                }
            }
        }
        return tweets;
    }

//    public List<AllDataSpring.Record> getSortedTweets(){
//        List<AllDataSpring.Record> tweets = new ArrayList<>();
//        for (AllDataSpring record : allDataRepository.findAll()) {
//            for (AllDataSpring.Record tweet : record.getRecords()) {
//                System.out.println(tweet.getTime());
//            }
//        }
//        return tweets;
//    }
}
