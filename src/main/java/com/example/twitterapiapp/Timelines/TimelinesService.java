package com.example.twitterapiapp.Timelines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelinesService {
    @Autowired
    TimelinesRepository timelinesRepository;
    public List<TimelinesSpring> getAllTimelines() {
        return timelinesRepository.findAll();
    }
}
