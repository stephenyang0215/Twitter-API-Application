package com.example.twitterapiapp.TweetsLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TweetsLookupController {
    @Autowired
    TweetsLookupService tweetsLookupService;

    @RequestMapping("/findAllTweetsLookup")
    @ResponseBody
    public List<TweetsLookupSpring> findAllTweetsLookup() {
        return tweetsLookupService.getAllTweetsLookup();
    }

}
