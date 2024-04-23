package com.example.twitterapiapp.Timelines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class TimelinesController {
    @Autowired
    TimelinesService timelinesService;

    @RequestMapping("/findAllTimelines")
    @ResponseBody
    public List<TimelinesSpring> findAllTimelines() {
        return timelinesService.getAllTimelines();
    }

}
