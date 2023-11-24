FROM openjdk:8-jre-alpine

RUN apk update

# Install tesseract library
RUN apk add --no-cache tesseract-ocr

# Download last language package
RUN mkdir -p /usr/share/tessdata
#ADD https://github.com/tesseract-ocr/tessdata/raw/master/eng.traineddata
ADD https://github.com/tesseract-ocr/tessdata_best/blob/main/eng.traineddata /ocrworker/tessdata/eng.traineddata

# Check the installation status
RUN tesseract --list-langs
RUN tesseract -v

# Set the location of the jar
ENV MICROSERVICE_HOME /backend/target/

# Set the name of the jar
ENV APP_FILE openapi-spring-1.0.jar

# Open the port
EXPOSE 8090

