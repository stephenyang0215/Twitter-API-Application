#!/bin/bash
ls -l
sleep 5

mongosh --authenticationDatabase admin "mongodb://root:password@mongodb:27017" --username root --password password --apiVersion 1
mongoimport --authenticationDatabase admin --uri="mongodb://root:password@mongodb:27017" --username root --password password --file Bookmarks-Lookup.json --collection bookmarksLookup
mongoimport --authenticationDatabase admin --uri="mongodb://root:password@mongodb:27017" --username root --password password --file Recent-Search.json  --collection recentSearch
mongoimport --authenticationDatabase admin --uri="mongodb://root:password@mongodb:27017" --username root --password password --file Timelines.json  --collection timelines
mongoimport --authenticationDatabase admin --uri="mongodb://root:password@mongodb:27017" --username root --password password --file Tweets-Lookup.json  --collection tweetsLookup
