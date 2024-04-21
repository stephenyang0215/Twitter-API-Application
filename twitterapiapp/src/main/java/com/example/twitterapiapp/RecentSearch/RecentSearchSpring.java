package com.example.twitterapiapp.RecentSearch;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recentSearch")
public class RecentSearchSpring {
    @Id
    private String id;

    private String record;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTweets() {
        return record;
    }

    public void setTweets(String tweets) {
        record = tweets;
    }
}
