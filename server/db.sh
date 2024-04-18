mongosh "mongodb://localhost:27017" --apiVersion 1
mongoimport --uri="mongodb://localhost:27017" --file= data/Bookmarks-Lookup.json  --collection bookmarksLookup
mongoimport --uri="mongodb://localhost:27017" --file= data/Recent-Search.json  --collection recentSearch
mongoimport --uri="mongodb://localhost:27017" --file= data/Timelines.json  --collection timelines
mongoimport --uri="mongodb://localhost:27017" --file= data/Tweets-Lookup.json  --collection tweetsLookup
mongoimport --uri="mongodb://localhost:27017" --file= data/postTweets.json  --collection postTweets