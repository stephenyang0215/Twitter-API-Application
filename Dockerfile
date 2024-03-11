FROM openjdk
WORKDIR /app
COPY src/main/java/org/example/ /app/
RUN javac *.java
CMD ["java", "Main"]