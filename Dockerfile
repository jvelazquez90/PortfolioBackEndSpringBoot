FROM amazoncorretto:8-alpine-jdk
MAINTAINER portfolio_velazquez
COPY SpringBoot/target/SpringBoot-0.0.1-SNAPSHOT.jar SpringBoot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/SpringBoot-0.0.1-SNAPSHOT.jar"]