import {AppShell, Container, Group, TextInput,Text, Button, Card, Stack, AppShellHeader } from '@mantine/core';
import { useState} from 'react';
import  SearchBar  from '@/components/SearchBar';
import  TweetCard  from '@/components/Card/TweetCard';

interface Tweet {
    _id: number,
    account: string,
    tweet: string,
    url: string,
    hashtag: string[],
    search: string[],
    share_tweet: {},
    share_url: string,
    time: string,
    views: number;
    }

export function AllDataSearchPage() {
    const [data, setData] = useState<Tweet[]>([]);
  
   
    
    const handleSearch = async (keyword: string) => {
        try {
            const response = await fetch(`http://localhost:8080/keywordFindTweets?keyword=${encodeURIComponent(keyword)}`); // Replace with your actual API endpoint
            const jsonData = await response.json();
            console.log(jsonData);
            setData(jsonData);
          } catch (error) {
            console.error('Error fetching data:', error);
          }
        
    }
   
    return(
    <AppShell>
        <Container>
        <h1>Search for post</h1>

                <Container>
           
           <SearchBar onSearch={handleSearch} ></SearchBar>
           {data.map((post: Tweet) =>
              <TweetCard
                  key={post._id}
                  account={post.account}
                  tweet={post.tweet}
                  url={post.url}
                  hashtag={post.hashtag}
                  search={post.search}
                  share_tweet={post.share_tweet}
                  share_url={post.share_url}
                  time={post.time}
                  views={post.views}
              />
          )}
        
      

             
        </Container>
         <AppShell.Navbar>
                            <Container>
                            <Stack>
                                <a href="/">HomePage</a>
                                      <a href="/alldata">All Post</a>
                                      <a href="/searchAll">Search Timeline</a>
                                      <a href="/searchPost">Search Post</a>
                                      <a href="/bookmarks">Bookmarks</a>
                                      <a href="/me">Profile</a>
                            </Stack>
                            </Container>
                        </AppShell.Navbar>
                        </Container>
                        </AppShell>
    )
    
}