FROM openjdk:17

RUN apk update

# Install tesseract library
RUN apk add --no-cache tesseract-ocr

# Download last language package
RUN mkdir -p /usr/share/tessdata
#ADD https://github.com/tesseract-ocr/tessdata/raw/master/eng.traineddata
ADD https://github.com/tesseract-ocr/tessdata_best/blob/main/eng.traineddata /usr/share/tessdata

# Check the installation status
RUN tesseract --list-langs
RUN tesseract -v

# Open the port
EXPOSE 8082





