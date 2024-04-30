/*
    Class: bookmarksLookupService
    Description: Building service for the Bookmarks endpoints
 */
package com.example.twitterapiapp.BookmarksLookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookmarksLookupService {
    @Autowired
    com.example.twitterapiapp.BookmarksLookup.bookmarksLookupRepository bookmarksLookupRepositary;
    public List<bookmarksLookupSpring> getAllBookmarks() {
        return bookmarksLookupRepositary.findAll();
    }
}
