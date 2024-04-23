package com.example.twitterapiapp.postTweets;

import com.twitter.clientlib.model.Get2UsersMeResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.example.findMyUser;
@Document(collection = "findMyUser")

public class findMyUserSpring {
    @Id
    private String id;

    private Get2UsersMeResponse me;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Get2UsersMeResponse getMe(String accessToken) {
        findMyUser me = new findMyUser(accessToken);
        return me.display();
    }

    public void setMe(Get2UsersMeResponse me) {
        this.me = me;
    }
}
