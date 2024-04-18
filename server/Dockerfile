FROM openjdk:17
COPY src /app
WORKDIR /app
COPY db.sh /app/db.sh
CMD java -classpath /app main.java.org.example.Main
#RUN /bin/bash -c '/app/db.sh'