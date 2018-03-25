FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE  8089
ADD /target/SpringDocker.jar SpringDocker.jar
ENTRYPOINT ["java","-jar","/SpringDocker.jar"]