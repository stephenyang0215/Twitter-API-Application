/*
    Class: TimelinesRepository
    Description: Building repository for the Timelines endpoints
 */
package com.example.twitterapiapp.Timelines;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimelinesRepository extends MongoRepository<TimelinesSpring,String> {

}
