FROM bellsoft/liberica-openjdk-debian:17

WORKDIR /app

COPY target/bank-api-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080