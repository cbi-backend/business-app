FROM maven:3.9.5 AS maven
LABEL MAINTAINER="cbi.backend@gmail.com"

COPY . .
RUN mvn package 

FROM openjdk:17

ARG JAR_FILE=card-2023.11.1-SNAPSHOT.jar

COPY --from=maven /target/${JAR_FILE} .

ENTRYPOINT ["java","-jar","card-2023.11.1-SNAPSHOT.jar"]