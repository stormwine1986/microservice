FROM openjdk:8-jre-alpine

EXPOSE 8081

COPY target/micro-service-a-0.0.1-SNAPSHOT.jar /

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/micro-service-a-0.0.1-SNAPSHOT.jar"]