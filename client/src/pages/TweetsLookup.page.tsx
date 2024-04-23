import TweetCard from '@/components/Card/TweetCard';
import { Container } from '@mantine/core';
import { useState, useEffect } from 'react';
import he from 'he';


// const data = 
// {
//   '_id': '6623f185258828ddf78e75f6',
//   record: [
//       {
//           _id: 1,
//           account: '@HowThingsWork_',
//           tweet: 'Shenzhen, China is looking like something straight from a sci-fi movie 😮',
//           url: 'https://twitter.com/HowThingsWork_/status/1766405458858782996',
//           hashtag: [],
//           search: [],
//           share_tweet: {
//               _id: 2,
//               account: '@RealUntoldStory',
//               tweet: 'Shenzhen, China',
//               url: 'https://twitter.com/RealUntoldStory/status/1766389376404029875',
//               hashtag: [],
//               search: [],
//               share_tweet: {},
//               share_url: '',
//               time: '4:03 AM · Mar 9, 2024',
//               views: 38200
//           },
//           share_url: '',
//           time: '5:07 AM · Mar 9, 2024',
//           views: 4300000
//       },
//       {
//           _id: 3,
//           account: '@fasc1nate',
//           tweet: 'Men in Harlem gather in front of a shop to listen to the radio, 1930.',
//           url: 'https://twitter.com/fasc1nate/status/1766562104998232318',
//           hashtag: [],
//           search: [],
//           share_tweet: {},
//           share_url: '',
//           time: '3:30 PM · Mar 9, 2024',
//           views: 52800
//       }
//   ]
// }

  
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

  // useEffect(() => {
  //   const fetchData = async () => {
  //     try {
  //       const response = await fetch('http://localhost:8080/findAllTweetsLookup'); // Replace with your actual API endpoint
  //       const jsonData = await response.json();
      
        
  //       setData(jsonData);
        
  //       console.log(jsonData);
  //     } catch (error) {
  //       console.error('Error fetching data:', error);
  //     }
  //   };
  //   fetchData();
   
  // });





    return(
        <div>
    
    <div>
   
            <h1>recent search</h1>
        </div>
        <Container >
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
       
     

{/* <div>
      {data.map((item) => (
        <div key={item.id} className="card">
          <h2>ID: {item.id}</h2>
          <ul>
            {JSON.parse(item.records).map((tweetObj: any, index: number) => {
              const tweet: Tweet = JSON.parse(tweetObj.tweet);
              return (
                <li key={index}>
                  <h3>{tweet.account}</h3>
                  <p>{tweet.tweet}</p>
                  <p>URL: {tweet.url}</p>
                  <p>Hashtags: {tweet.hashtag.join(', ')}</p>
                  <p>Search: {tweet.search.join(', ')}</p>
                  <p>Time: {tweet.time}</p>
                  <p>Views: {tweet.views}</p>
                </li>
              );
            })}
          </ul>
        </div>
      ))}
    </div>*/}
   </div>
    )
  }
    
