FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
COPY target/loan-service-0.0.1-SNAPSHOT.jar $PROJECT_HOME/loan-service.jar
WORKDIR $PROJECT_HOME
EXPOSE 8102
CMD ["java", "-Dspring.data.mongodb.uri=mongodb://localhost:27017/loan_db","-Djava.security.egd=file:/dev/./urandom","-jar","./loan-service.jar"]
