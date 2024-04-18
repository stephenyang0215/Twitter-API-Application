package com.example.twitterapiapp.tweet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetController {

    @RequestMapping("/")
    String home(){
        return "this is home page";

    }

//    @GetMapping("/lookup")
//    public String lookupTweet(String keyword) {
//        return null;
//    }
}
