FROM openjdk:8

RUN mkdir /app

ADD target/classes/temp-service.yml /app/temp-service.yml

ADD target/interview-project-1.0-SNAPSHOT.jar /app/interview-project-1.0-SNAPSHOT.jar

CMD java -jar /app/interview-project-1.0-SNAPSHOT.jar server /app/temp-service.yml
EXPOSE 8080