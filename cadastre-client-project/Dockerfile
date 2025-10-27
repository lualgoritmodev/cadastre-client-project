FROM openjdk:17-jdk

COPY build/libs/cadastre-client-project-0.0.1-SNAPSHOT-plain.jar /cadastreclientproject.jar

ENV SPRING_PROFILES_ACTIVE=default

ENTRYPOINT ["java", "-jar", "/cadastreclientproject.jar"]