### STAGE 1: Build ###
FROM registry.devopsnonprd.vayuktbcs:8082/maven:3-alpine AS builder
RUN export JAVA_HOME
RUN mkdir -p /root/.m2/repository
RUN mkdir -p /usr/src/app
RUN mkdir -p /usr/src/app/jarfile
ADD ktbcs-root-ca.pem /usr/local/share/ca-certificates/ktbcs-root-ca.pem
RUN chmod 644 /usr/local/share/ca-certificates/ktbcs-root-ca.pem && update-ca-certificates
WORKDIR /usr/src/app
COPY settings.xml /root/.m2
#COPY src/ /usr/src/app/src
#COPY pom.xml /usr/src/app
COPY . /usr/src/app
RUN mvn -U clean
RUN mvn -U install
RUN ls /usr/src/app
RUN ls /usr/src/app/auth-service/target/
RUN pwd
RUN cp /usr/src/app/auth-service/target/auth-service.jar /usr/src/app/jarfile/
RUN cp /usr/src/app/maker-service/target/maker-service.jar /usr/src/app/jarfile/
RUN cp /usr/src/app/request-service/target/request-service.jar /usr/src/app/jarfile/
RUN cp /usr/src/app/document-server/target/document-server.jar /usr/src/app/jarfile/
RUN ls /usr/src/app/jarfile/
RUN java -version
#ENTRYPOINT ["java","-jar","/usr/src/app/target/brs-webservice.jar"]
