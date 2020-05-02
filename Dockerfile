FROM adoptopenjdk/openjdk11:alpine

RUN apk --no-cache add curl

EXPOSE 8080/tcp

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

HEALTHCHECK CMD curl -f http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java","-jar","/app.jar"]

ENV AWS_ACCESS_KEY_ID=none
ENV AWS_SECRET_ACCESS_KEY=none
