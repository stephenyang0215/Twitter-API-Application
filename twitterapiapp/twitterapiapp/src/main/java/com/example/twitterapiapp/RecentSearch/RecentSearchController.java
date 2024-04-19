package com.example.twitterapiapp.RecentSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecentSearchController {
    @Autowired
    RecentSearchService recentSearchService;

    @RequestMapping("/findAllRecentSearch")
    @ResponseBody
    public List<RecentSearchSpring> findAllRecentSearch() {
        return recentSearchService.getAllRecentSearch();
    }

}
