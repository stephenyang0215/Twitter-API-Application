import Card from '@/components/Card/TweetCard';
import { Container } from '@mantine/core';
const data =
{
    "records": [
      {
        "_id": 1,
        "account": "@TheFigen_",
        "tweet": "Being late does not mean failure, maybe it means getting ready for a great launch!",
        "url": "https://twitter.com/TheFigen_/status/1766134280185426166",
        "hashtag": [],
        "search": [],
        "share_tweet": {},
        "share_url": "",
        "time": "11:10 AM · Mar 8, 2024",
        "views": 81400
      },
      {
        "_id": 2,
        "account": "@realamrutpatil",
        "tweet": "Why some tech projects fail and others succeed could surprise you. It's not always about the tech stack or the budget. The difference often lies in the planning phase.Successful projects are marked by: • Clear Objectives• Stakeholder Alignment• Risk Management Strategies• Agile Methodology Adoption• Regular Feedback Loops Attention to these areas can significantly reduce project failure rates.",
        "hashtag": [],
        "search": [],
        "share_tweet": {},
        "share_url": "",
        "time": "8:16 AM · Mar 9, 2024",
        "views": 95
      }
    ]
  }

export function BookmarksPage() {
    return(
        <Container>
    <div>
            <h1>Bookmarks</h1>
        </div>
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
    
        </Container>
    )
    
}