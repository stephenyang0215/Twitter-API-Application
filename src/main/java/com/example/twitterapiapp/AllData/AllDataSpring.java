package com.example.twitterapiapp.AllData;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "allData")
public class AllDataSpring {
//    @Id
//    private String id;


    public List<Record> records;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }


    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }


    public class Record {

        private Integer id;

        public String tweet;
        private String account;
        private String url;
        private List<String> hashtag;  // Assuming hashtags are stored as an array of strings
        private List<String> search;  // Assuming search terms are stored as an array of strings
        private String shareUrl;  // Combined share_url property (optional)
        private Date time;
        private Long views;

        public Integer getId(){
            return id;
        }

        public void setId(Integer id){
            this.id = id;
        }

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

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
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


