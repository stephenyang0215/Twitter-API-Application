package com.example.twitterapiapp.RecentSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecentSearchService {
    @Autowired
    RecentSearchRepository recentSearchRepository;
    public List<RecentSearchSpring> getAllRecentSearch() {
        return recentSearchRepository.findAll();
    }
}
