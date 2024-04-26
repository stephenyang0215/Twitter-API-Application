package com.example.twitterapiapp.TweetsLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class TweetsLookupController {
    @Autowired
    TweetsLookupService tweetsLookupService;


    @RequestMapping("/findAllTweetsLookup")
    @ResponseBody
    public List<TweetsLookupSpring> findAllTweetsLookup() {
        return tweetsLookupService.getAllTweetsLookup();
    }

    @RequestMapping("/findTweetsLookupByTerm")
    @ResponseBody
    public List<TweetsLookupSpring> findTweetsLookupByTerm(@RequestParam("term") String term) {
        return tweetsLookupService.getTweetsLookupByTerm(term);
    }

}
