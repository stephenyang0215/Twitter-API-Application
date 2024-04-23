import {useState, useEffect} from 'react';
import { Container } from '@mantine/core';
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
        <>
         <div>
            <h1>time line</h1>
            
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
                  time={post.time}
                  views={post.views}
              />
          ))
        })}

        </Container>
        </>
       
    )
}