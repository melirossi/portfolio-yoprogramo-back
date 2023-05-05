FROM amazoncorretto:11-alpine-jdk
MAINTAINER MelisaRossi
COPY target/melisa-0.0.1-SNAPSHOT.jar  melisa-app.jar
ENTRYPOINT ["java","-jar","/melisa-app.jar"]
