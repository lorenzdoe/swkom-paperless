# here will be builder stage
# no builder stage yet because building takes much time
# just build the .jar file manually
# --- --- ---
# run the application
# manually build .jar file by mvn package
FROM eclipse-temurin:17-jdk-alpine
COPY target/*.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/app.jar"]