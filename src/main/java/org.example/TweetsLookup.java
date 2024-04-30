/*
    Class: TweetsLookup
    Description: Parsing the Lookup data to store in the database
 */
package org.example;

import org.bson.Document;
import java.util.List;

public class TweetsLookup {
    Database db = new Database();

    public void parsing(String collection, String keyword) {
        List<Document> retrieve = db.lookUp(collection, keyword);

        for (Document record: retrieve){
            // get the values from json object
            Integer userid = (Integer) record.get("_id");
            String account = (String) record.get("account");
            String tweet = (String) record.get("tweet");
            String url = (String) record.get("url");
            System.out.printf("userid : %d\naccount: %s\ntweet: %s\nurl: %s\n", userid, account, tweet, url);

            Object hashtag = record.get("hashtag");
            System.out.println("hashtags: " + hashtag.toString());

            Object search = record.get("search");
            System.out.println("search: " + search);

            Object share_tweet = record.get("share_tweet");
            System.out.println("share_tweet: " + share_tweet);

            String share_url = (String) record.get("share_url");
            String time = (String) record.get("time");
            Integer views = (Integer) record.get("views");
            System.out.printf("share_url: %s\ntime: %s\nviews: %d\n", share_url, time, views);
        }
    }
}