FROM openjdk:8-jdk-alpine

WORKDIR /app

VOLUME /app

COPY ./target/clima-app-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "clima-app-0.0.1-SNAPSHOT.jar"]