package com.example.twitterapiapp.BookmarksLookup;

import com.example.twitterapiapp.postTweets.postTweetsSpring;
import com.twitter.clientlib.model.Get2UsersMeResponse;
import org.example.findMyUser;
import org.example.postTweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookmarksLookupService {
    @Autowired
    com.example.twitterapiapp.BookmarksLookup.bookmarksLookupRepository bookmarksLookupRepositary;
    public List<bookmarksLookupSpring> getAllBookmarks() {
        return bookmarksLookupRepositary.findAll();
    }
}
