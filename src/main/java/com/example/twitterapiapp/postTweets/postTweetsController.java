package com.example.twitterapiapp.postTweets;
import com.twitter.clientlib.model.Get2UsersMeResponse;
//import org.example.findMyUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.postTweet;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
public class postTweetsController {
    @Autowired
    postTweetsService postTweetsService;
    @RequestMapping("/findTweetsById")
    @ResponseBody
    public postTweetsSpring findTweetsById(@RequestParam("id") String id) {
        return postTweetsService.getByTweetsId(id);
    }

    @RequestMapping("/findAllTweets")
    @ResponseBody
    public List<postTweetsSpring> findAllTweets() {
        return postTweetsService.getAllTweets();
    }

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

    @RequestMapping("/removeTweetsById")
    @ResponseBody
    public String removeTweets(@RequestParam("accessToken") String accessToken,
                                            @RequestParam("id") String id) {
        postTweetsService.removeTweets(accessToken, id);
        return "Successfully delete the record!";
    }


}
