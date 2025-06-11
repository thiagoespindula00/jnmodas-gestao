FROM bellsoft/liberica-openjre-alpine:24.0.1
LABEL authors="thiagoespindula00"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
