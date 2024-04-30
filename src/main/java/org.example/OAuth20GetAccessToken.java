/*
    Class: OAuth20GetAccessToken
    Description: fetch the access token for application from OAUTH 2.0 authorization on Twitter server
 */
package org.example;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.pkce.PKCE;
import com.github.scribejava.core.pkce.PKCECodeChallengeMethod;
import com.twitter.clientlib.auth.TwitterOAuth20Service;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import java.util.Scanner;

public class OAuth20GetAccessToken {
    TwitterCredentialsOAuth2 credentials;
    public OAuth20GetAccessToken() {
        this.credentials = new TwitterCredentialsOAuth2(System.getenv("TWITTER_OAUTH2_CLIENT_ID"),
                System.getenv("TWITTER_OAUTH2_CLIENT_SECRET"),
                System.getenv("TWITTER_OAUTH2_ACCESS_TOKEN"),
                System.getenv("TWITTER_OAUTH2_REFRESH_TOKEN"));

        OAuth2AccessToken accessToken = getAccessToken(this.credentials);
        if (accessToken == null) {
            return;
        }

        this.credentials.setTwitterOauth2AccessToken(accessToken.getAccessToken());
        this.credentials.setTwitterOauth2RefreshToken(accessToken.getRefreshToken());
    }
    public TwitterCredentialsOAuth2 getCredentials() {
        return this.credentials;
    }
    public static OAuth2AccessToken getAccessToken(com.twitter.clientlib.TwitterCredentialsOAuth2 credentials){
        TwitterOAuth20Service service = new TwitterOAuth20Service(
                credentials.getTwitterOauth2ClientId(),
                credentials.getTwitterOAuth2ClientSecret(),
                "https://oauth.pstmn.io/v1/callback",
                "tweet.write tweet.read users.read offline.access");

        OAuth2AccessToken accessToken = null;
        try {
            final Scanner in = new Scanner(System.in, "UTF-8");
            System.out.println("Fetching the Authorization URL...");

            final String secretState = "state";
            PKCE pkce = new PKCE();
            pkce.setCodeChallenge("challenge");
            pkce.setCodeChallengeMethod(PKCECodeChallengeMethod.PLAIN);
            pkce.setCodeVerifier("challenge");
            String authorizationUrl = service.getAuthorizationUrl(pkce, secretState);

            System.out.println("Go to the Authorization URL and authorize your App:\n" +
                    authorizationUrl + "\nAfter that paste the authorization code here\n>>");
            final String code = in.nextLine();
            System.out.println("\nTrading the Authorization Code for an Access Token...");
            accessToken = service.getAccessToken(pkce, code);

            System.out.println("Access token: " + accessToken.getAccessToken());
            System.out.println("Refresh token: " + accessToken.getRefreshToken());
        } catch (Exception e) {
            System.err.println("Error while getting the access token:\n " + e);
            e.printStackTrace();
        }
        return accessToken;
    }
}
