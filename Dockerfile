FROM adoptopenjdk/openjdk17:alpine-jre

EXPOSE 8083
COPY target/sales-0.0.1-SNAPSHOT.jar sales-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/sales-0.0.1-SNAPSHOT.jar"]