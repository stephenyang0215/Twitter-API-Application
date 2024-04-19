package com.example.twitterapiapp.TweetsLookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetsLookupService {
    @Autowired
    TweetsLookupRepository tweetsLookupRepository;
    public List<TweetsLookupSpring> getAllTweetsLookup() {
        return tweetsLookupRepository.findAll();
    }
}
