FROM openjdk
WORKDIR /app
COPY *.java /app/
RUN javac *.java
CMD ["java", "Main"]