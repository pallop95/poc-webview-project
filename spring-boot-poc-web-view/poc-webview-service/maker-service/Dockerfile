FROM registry.devopsnonprd.vayuktbcs:8082/maven:3-alpine AS builder
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]