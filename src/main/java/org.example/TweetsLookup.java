package org.example;

import org.bson.Document;

public class TweetsLookup {

    Database db = new Database();

    public void parsing(String collection, int id) {
        Document retrieve = db.lookUp(collection, id);

        // get the values from json object
        Integer userid = (Integer) retrieve.get("_id");
        String account = (String) retrieve.get("account");
        String tweet = (String) retrieve.get("tweet");
        String url = (String) retrieve.get("url");
        System.out.printf("userid : %d\naccount: %s\ntweet: %s\nurl: %s\n", userid, account, tweet, url);

        Object hashtag = retrieve.get("hashtag");
        System.out.println("hashtags: " + hashtag.toString());

        Object search = retrieve.get("search");
        System.out.println("search: " + search);

        Object share_tweet = retrieve.get("share_tweet");
        System.out.println("share_tweet: " + share_tweet);

        String share_url = (String) retrieve.get("share_url");
        String time = (String) retrieve.get("time");
        Integer views = (Integer) retrieve.get("views");
        System.out.printf("share_url: %s\ntime: %s\nviews: %d\n", share_url, time, views);
    }
}