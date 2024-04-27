FROM mongo:5.0.0-focal

COPY Bookmarks-Lookup.json /Bookmarks-Lookup.json
COPY Recent-Search.json /Recent-Search.json
COPY Timelines.json /Timelines.json
COPY Tweets-Lookup.json /Tweets-Lookup.json
COPY AllData.json /AllData.json

ADD ./db.sh ./db.sh
RUN chmod +x ./db.sh

#CMD ["./db.sh"]