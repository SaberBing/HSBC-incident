# Use an official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-slim

WORKDIR /app
COPY target/incident-management-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
