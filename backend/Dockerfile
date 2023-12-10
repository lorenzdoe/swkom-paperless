# builder stage
FROM amazoncorretto:17-al2023-jdk as builder
WORKDIR /app
COPY . .
# install maven and build the .jar file (on amazon linux image)
RUN yum install -y maven
RUN mvn package

FROM openjdk:17 as runner
COPY --from=builder ./app/target/*.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/app.jar"]