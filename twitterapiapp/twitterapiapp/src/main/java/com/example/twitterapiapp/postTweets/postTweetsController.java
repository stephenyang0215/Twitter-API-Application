package com.example.twitterapiapp.postTweets;
import com.twitter.clientlib.model.Get2UsersMeResponse;
import org.example.findMyUser;
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
    @RequestMapping("/getTweetsById")
    @ResponseBody
    public postTweetsSpring getTweetsById(@RequestParam("id") String id) {
        return postTweetsService.getTweetsById(id);
    }

    //@RequestMapping("/findAllTweets")
    //@ResponseBody
    //public String findAllTweets() {
    //    return postTweetsService.findAllTweets();
    //}

    @RequestMapping("/addTweets")
    @ResponseBody
    public String addTweets(@RequestParam("accessToken") String accessToken,
                            @RequestParam("Tweets") String Tweets) {
        postTweetsService.addTweets(Tweets, accessToken);
        return "Successfully add the record!";
    }

    @RequestMapping("/me")
    @ResponseBody
    public Get2UsersMeResponse findMyUser(@RequestParam("accessToken") String accessToken) {
        return postTweetsService.findMyUser(accessToken);
    }
}
