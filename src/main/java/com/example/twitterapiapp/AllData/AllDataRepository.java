/*
    Class: AllDataRepository
    Description: Building repository for the All Data endpoints
 */
package com.example.twitterapiapp.AllData;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AllDataRepository extends MongoRepository<AllDataSpring,String> {

}
