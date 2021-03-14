FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/air_management_system-0.0.1-SNAPSHOT.jar air_management_system-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/air_management_system-0.0.1-SNAPSHOT.jar"]

