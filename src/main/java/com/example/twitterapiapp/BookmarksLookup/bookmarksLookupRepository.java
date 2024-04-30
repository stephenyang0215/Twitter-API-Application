/*
    Class: bookmarksLookupRepository
    Description: Building repository for the bookmarks endpoints
 */
package com.example.twitterapiapp.BookmarksLookup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface bookmarksLookupRepository extends MongoRepository<bookmarksLookupSpring,String> {

}
