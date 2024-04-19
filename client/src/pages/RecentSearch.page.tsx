import Card from '@/components/Card/TweetCard';
import { Container } from '@mantine/core';
const data =
{
    "record": [
      {
        "_id": 1,
        "account": "@HowThingsWork_",
        "tweet": "Shenzhen, China is looking like something straight from a sci-fi movie 😮",
        "url": "https://twitter.com/HowThingsWork_/status/1766405458858782996",
        "hashtag": [],
        "search": [],
        "share_tweet": {
          "_id": 2,
          "account": "@RealUntoldStory",
          "tweet": "Shenzhen, China",
          "url": "https://twitter.com/RealUntoldStory/status/1766389376404029875",
          "hashtag": [],
          "search": [],
          "share_tweet": {},
          "share_url": "",
          "time": "4:03 AM · Mar 9, 2024",
          "views": 38200
        },
        "share_url": "",
        "time": "5:07 AM · Mar 9, 2024",
        "views": 4300000
      },
      {
        "_id": 3,
        "account": "@fasc1nate",
        "tweet": "Men in Harlem gather in front of a shop to listen to the radio, 1930.",
        "url": "https://twitter.com/fasc1nate/status/1766562104998232318",
        "hashtag": [],
        "search": [],
        "share_tweet": {},
        "share_url": "",
        "time": "3:30 PM · Mar 9, 2024",
        "views": 52800
      }
    ]
  }
export function RecentSearchPage() {
    return(
        <div>
   <div>
            <h1>recent search</h1>
        </div>
        <Container>
            {data.record.map((post) => (
                <Card
                    key={post._id}
                    account={post.account}
                    tweet={post.tweet}
                    time={post.time}
                    views={post.views}
                />
            ))}
        </Container>
        </div>
     
    )
}
    