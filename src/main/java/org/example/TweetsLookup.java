package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

import java.io.FileReader;
import java.io.IOException;

public class TweetsLookup {

    // file path
    private final String filePath = "data/Tweets-Lookup.json";

    public void parsing(int id) {
        try{
            // parsing json file
            Object parse = new JSONParser().parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) parse;
            JSONArray tweets = (JSONArray) jsonObject.get("records");
            // when search we want it go by id not index so -1
            JSONObject retrieve = (JSONObject) tweets.get(id - 1);

            // get the values from json object
            Long userid = (Long) retrieve.get("_id");
            String account = (String) retrieve.get("account");
            String tweet = (String) retrieve.get("tweet");
            String url = (String) retrieve.get("url");
            System.out.printf("userid : %d\naccount: %s\ntweet: %s\nurl: %s\n", userid, account, tweet, url);

            JSONArray hashtag = (JSONArray) retrieve.get("hashtag");
            System.out.println("hashtags: " + hashtag.toString());

            JSONArray search = (JSONArray) retrieve.get("search");
            System.out.println("search: " + search);

            JSONObject share_tweet = (JSONObject) retrieve.get("share_tweet");
            System.out.println("share_tweet: " + share_tweet);

            String share_url = (String) retrieve.get("share_url");
            String time = (String) retrieve.get("time");
            Long views = (Long) retrieve.get("views");
            System.out.printf("share_url: %s\ntime: %s\nviews: %d", share_url, time, views);

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

    }
}