import Card from '@/components/Card/TweetCard';
import { Container } from '@mantine/core';
const data = 
{ "records": [
    {
      "_id": 1,
      "account": "@ali_charts",
      "tweet": "#ShibaInu forms a symmetrical triangle on the 4-hour chart. A sustained close above the $0.000038 resistance could trigger a 40% bullish breakout, pushing $SHIB toward $0.000052. Watch out for $0.000033 since losing this support level will invalidate the bullish outlook.",
      "url": "https://twitter.com/ali_charts/status/1766510211563401573",
      "hashtag": ["#ShibaInu"],
      "search": ["$SHIB"],
      "share_tweet": {},
      "share_url": "",
      "time": "12:03 PM · Mar 9, 2024",
      "views": 11200
    },
    {
      "_id": 2,
      "account": "@elonmush",
      "tweet": "Coming soon",
      "url": "https://twitter.com/elonmusk/status/1766304130690056322",
      "hashtag": [],
      "search": [],
      "share_tweet": {
        "_id": 3,
        "account": "@cb_doge",
        "tweet": "You can soon watch your favorite 𝕏 long form videos directly on your SmartTVs.",
        "url": "https://twitter.com/cb_doge/status/1766303980320063556",
        "hashtag": [],
        "search": [],
        "share_tweet": {},
        "share_url": "",
        "time": "10:24 PM · Mar 8, 2024",
        "views": 281000000
      },
      "share_url": "",
      "time": "10:24 PM · Mar 8, 2024",
      "views": 42000000
    },
    {
      "_id": 4,
      "account": "@XDevelopers",
      "tweet": "Calling all #developers! 📣 Innovate with our real-time and historical data on the X API. Get started with Pro👇",
      "url": "https://twitter.com/elonmusk/status/1766304130690056322",
      "hashtag": [],
      "search": [],
      "share_tweet": {},
      "share_url": "https://developer.twitter.com/en/portal/products/pro?twclid=2-1uhiad623ec5au6uxasb2o1le",
      "time": "7:01 AM · Nov 2, 2023",
      "views": 498000000
    },
    {
      "_id": 5,
      "account": "@XDevelopers",
      "tweet": "Calling all #developers! 📣 Innovate with our real-time and historical data on the X API. Get started with Pro👇",
      "url": "https://twitter.com/elonmusk/status/1766304130690056322",
      "hashtag": [],
      "search": [],
      "share_tweet": {},
      "share_url": "https://developer.twitter.com/en/portal/products/pro?twclid=2-1uhiad623ec5au6uxasb2o1le",
      "time": "7:01 AM · Nov 2, 2023",
      "views": 498000000
    }
    ]
  }
  
  
  
  
  
  
  



export function TweetsLookupPage() {
    return(
        <div>
            <h1>Lookup</h1>
       
        <Container>
            {data.records.map((post) => (
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