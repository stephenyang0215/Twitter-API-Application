import {useState, useEffect} from 'react';
import {AppShell, Container, Group, TextInput,Text, Button, Card, Stack, AppShellHeader } from '@mantine/core';
import TweetCard from '@/components/Card/TweetCard';
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
    tweets: Tweet[];
  }

export function TimelinePage() {
    const [data, setData] = useState<dataItem[]>([]);

    useEffect(() => {
        fetch('http://localhost:8080/findAllTimelines') // replace with your actual endpoint
          
          .then(response => response.json())
          
          .then(data => setData(data))
          .then(data => console.log(data));
          
      }, []);
    return(
        <AppShell>
        <Container>
            <div>
               <h1>Timeline</h1>
            </div>
        <Container>
        {data.map((item: dataItem) => {
            console.log(item.id),
            console.log(typeof item.id),
            console.log(item.tweets),
            console.log(typeof item.tweets);
            return item.tweets.map((post: Tweet) => (
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
          ))
        })}

        </Container>
                <AppShell.Navbar>
                <Container>
                    <Stack>
                        <a href="/">HomePage</a>
                                        <a href="/bookmarks">Bookmarks</a>
                                        <a href="/lookup">Look up</a>
                                        <a href="/recentsearch">Recent search</a>
                                        <a href="/timeline">Timelines</a>
                    </Stack>
                    </Container>
                </AppShell.Navbar>
        </Container>
                </AppShell>
       
    )
}