package com.example.twitterapiapp.RecentSearch;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "recentSearch")
public class RecentSearchSpring {
    @Id
    private String id;

    private List<Record> record;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Record> getTweets() {
        return record;
    }

    public void setTweets(List<Record> tweets) {
        record = tweets;
    }

    public class Record {
        private String tweet;
        private String account;
        private String url;
        private List<String> hashtag;  // Assuming hashtags are stored as an array of strings
        private List<String> search;  // Assuming search terms are stored as an array of strings
        private String shareUrl;  // Combined share_url property (optional)
        private String time;
        private Long views;

        public String getTweet() {
            return tweet;
        }

        public void setTweet(String tweet) {
            this.tweet = tweet;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getHashtag() {
            return hashtag;
        }

        public void setHashtag(List<String> hashtag) {
            this.hashtag = hashtag;
        }

        public List<String> getSearch() {
            return search;
        }

        public void setSearch(List<String> search) {
            this.search = search;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Long getViews() {
            return views;
        }

        public void setViews(Long views) {
            this.views = views;
        }
    }
}
