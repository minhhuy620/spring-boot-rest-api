FROM openjdk:18-ea-11-jdk-alpine3.15 as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY .m2 .m2
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests -s .m2/settings.xml

FROM openjdk:18-ea-11-jdk-alpine3.15
COPY --from=build  /workspace/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]