# Image for build the project
FROM maven:3.9.1-amazoncorretto-19 as maven
#FROM maven:3.8.3-openjdk-8 as maven
# copy pom to get off-line dependencies
COPY ./pom.xml ./pom.xml
# copy your other files
COPY ./data ./data
COPY ./src ./src
# build up project
RUN mvn dependency:go-offline package -B
# Create a new light container just with compiled jar
FROM maven:3.9.1-amazoncorretto-19
COPY --from=maven ./target/twitterapiapp-0.0.1-SNAPSHOT-launcher.jar ./app.jar
#FROM openjdk:8-jdk-alpine
#COPY --from=maven target/Final_Project-1.0-SNAPSHOT-launcher.jar ./app.jar
ENTRYPOINT ["java","-jar","./app.jar"]
