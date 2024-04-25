import TweetCard from '@/components/Card/TweetCard';
import {AppShell, Container, Group, TextInput,Text, Button, Card, Stack, AppShellHeader } from '@mantine/core';
import { useState, useEffect } from 'react';
import he from 'he';

  
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



interface dataItem {
  id: string,
  records: Tweet[];
}

export function TweetsLookupPage() {
  // const [data, setData] = useState([]);
  
  const [data, setData] = useState<dataItem[]>([]);



  useEffect(() => {
    fetch('http://localhost:8080/findAllTweetsLookup') // replace with your actual endpoint
      
      .then(response => response.json())
      
      .then(data => setData(data))
      .then(data => console.log(data));
      
  }, []);

    return(
        <AppShell>
                <Container>
                    <div>
                       <h1>Look Up</h1>
                    </div>
                <Container>
          {data.map((item: dataItem) => {
            console.log(item.id),
            console.log(typeof item.id),
            console.log(item.records),
            console.log(typeof item.records);
            return item.records.map((post: Tweet) => (
              <TweetCard
                  key={post._id}
                  account={post.account}
                  tweet={post.tweet}
                  time={post.time}
                  views={post.views}
              />
          ))
        })}
          
            
        </Container>
        <AppShell.Navbar>
        <Container>
           <Stack>
                <a href="/">HomePage</a>
                <a href="/bookmarks">Bookmarks</a>
                <a href="/recentsearch">Recent search</a>
                <a href="/timeline">Timelines</a>
           </Stack>
           </Container>
        </AppShell.Navbar>
        </Container>
        </AppShell>
    )
  }
    
