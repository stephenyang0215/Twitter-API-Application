/*
    Class: LoginController
    Description: The controller for the login endpoint
 */
package com.example.twitterapiapp.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
    @Autowired
    loginService loginService;

    @GetMapping("/")
    public String login() {
        return "This is home page";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String accessToken() {
        String client_id = System.getenv("TWITTER_OAUTH2_CLIENT_ID2");
        String url = "https://twitter.com/i/oauth2/authorize?code_challenge=challenge&code_challenge_method=PLAIN&response_type=code&client_id="
                +client_id+"&redirect_uri=http%3A%2F%2F127.0.0.1%3A8080%2FaccessTokenByCode&" +
                "scope=tweet.write%20tweet.read%20users.read%20offline.access&state=state"
                ;
        return url;
    }

    @RequestMapping("/accessTokenByCode")
    @ResponseBody
    public String accessTokenByCode(@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse response) {
        String pkce_code = loginService.callOauth2(code);
        System.out.println("Access Token: "+pkce_code);
        if (pkce_code !=null){
            UserDetails userDetails = createUserDetails(pkce_code);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, pkce_code, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String redirectUrl = "http://localhost:5173/auth-success?token=" + pkce_code;
            try {
                response.sendRedirect(redirectUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "Auth successful. Access token: " + pkce_code;
        }else {
            return "auth failed, unable to get access token";
        }

    }
    private UserDetails createUserDetails(String pkce_code){
        return User.withUsername("user")
                .password("")
                .authorities("ROLE_USER")
                .build();
    }

    }

