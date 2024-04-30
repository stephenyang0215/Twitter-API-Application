/*
    Class: loginRepository
    Description: Building repository for the login endpoints
 */
package com.example.twitterapiapp.login;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface loginRepository extends MongoRepository<loginSpring,String> {
}
