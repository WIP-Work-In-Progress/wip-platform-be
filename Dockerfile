FROM maven:latest as builder

WORKDIR /app

COPY . .

RUN ["mvn", "clean", "build"]

FROM openjdk:21-jdk

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]

