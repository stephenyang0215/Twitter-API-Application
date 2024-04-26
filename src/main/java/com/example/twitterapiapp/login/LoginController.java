package com.example.twitterapiapp.login;

import ch.qos.logback.core.model.Model;
import com.example.twitterapiapp.postTweets.postTweetsService;
import com.twitter.clientlib.model.TweetCreateRequest;
import org.example.findMyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    loginService loginService;

    @GetMapping("/")
    public String login() {
        return "This is home page";
    }

    @RequestMapping("/accessToken")
    @ResponseBody
    public String accessToken() {
        String  accessToken = loginService.Oauth2();
        return "Successfully add the record!";
    }

    }

