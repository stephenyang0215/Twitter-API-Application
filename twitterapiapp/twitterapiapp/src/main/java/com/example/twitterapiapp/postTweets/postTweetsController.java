package com.example.twitterapiapp.postTweets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.example.postTweet;

@RestController
public class postTweetsController {
    @Autowired
    postTweetsService postTweetsService;
    @RequestMapping("/getTweets")
    @ResponseBody
    public postTweetsSpring getTweetsById(@RequestParam("id") String id) {
        return postTweetsService.getTweetsById(id);
    }

    @RequestMapping("/addTweets")
    @ResponseBody
    public String addTweets(@RequestParam("accessToken") String accessToken,
                            @RequestParam("Tweets") String Tweets) {
        new postTweet(accessToken, Tweets);
        postTweetsService.addTweets(Tweets);
        return "Successfully add the record!";
    }
}
