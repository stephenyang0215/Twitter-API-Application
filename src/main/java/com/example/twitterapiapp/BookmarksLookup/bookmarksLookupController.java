package com.example.twitterapiapp.BookmarksLookup;
import com.example.twitterapiapp.postTweets.postTweetsSpring;
import com.twitter.clientlib.model.Get2UsersMeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class bookmarksLookupController {
    @Autowired
    com.example.twitterapiapp.BookmarksLookup.bookmarksLookupService bookmarksLookupService;

    @RequestMapping("/findAllBookmarks")
    @ResponseBody
    public List<bookmarksLookupSpring> findAllTweets() {
        return bookmarksLookupService.getAllBookmarks();
    }

}
