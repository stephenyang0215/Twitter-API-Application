package com.example.twitterapiapp.Timelines;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "timelines")
public class TimelinesSpring {
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
