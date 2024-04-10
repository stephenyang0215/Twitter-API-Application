# Image for build the project
FROM maven:3.8.3-openjdk-8 as maven
# copy pom to get off-line dependencies
COPY pom.xml ./pom.xml
# copy your other files
COPY ./src ./src
# build up project
RUN mvn dependency:go-offline package -B
# Create a new light container just with compiled jar
FROM openjdk:8-jdk-alpine
COPY --from=maven target/Final_Project-1.0-SNAPSHOT-launcher.jar ./app.jar
ENTRYPOINT ["java","-jar","./app.jar"]
#RUN mkdir /app
#COPY . /app
#WORKDIR /app

#RUN javac /src/main/java/org/example/Main.java
#CMD ["java", "Main"]
#COPY db.sh /app/db.sh
#RUN /bin/bash -c '/app/db.sh'


