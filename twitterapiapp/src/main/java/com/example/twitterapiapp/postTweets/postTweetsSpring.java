package com.example.twitterapiapp.postTweets;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "postTweets")
public class postTweetsSpring {
    @Id
    private String id;

    private String Tweets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTweets() {
        return Tweets;
    }

    public void setTweets(String tweets) {
        Tweets = tweets;
    }
}
