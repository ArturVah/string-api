FROM azul/zulu-openjdk-alpine:17.0.1 as builder
COPY target/string-api-1.0-SNAPSHOT.jar string-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/string-api-0.0.1-SNAPSHOT.jar"]
