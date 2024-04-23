package com.example.twitterapiapp.BookmarksLookup;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookmarksLookup")
public class bookmarksLookupSpring {
    @Id
    private String id;

    private String records;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTweets() {
        return records;
    }

    public void setTweets(String tweets) {
        records = tweets;
    }
}
