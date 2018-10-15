FROM openjdk:8
ADD target/spring-boot-graphql-1.0-SNAPSHOT.jar spring-boot-graphql-1.0-SNAPSHOT.jar
EXPOSE 5555
ENTRYPOINT ["java", "-jar", "spring-boot-graphql-1.0-SNAPSHOT.jar"]