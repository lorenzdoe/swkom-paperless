# OpenJDK 17 Image based on Debian
FROM openjdk:17-bullseye

# Update the package list and install tesseract-ocr
RUN apt-get update && \
    apt-get install -y tesseract-ocr && \
    rm -rf /var/lib/apt/lists/*

# Download the English language package for Tesseract
RUN mkdir -p /usr/share/tesseract-ocr/4.00/tessdata
ADD https://github.com/tesseract-ocr/tessdata_best/raw/main/eng.traineddata /usr/share/tesseract-ocr/4.00/tessdata/

# Verify Tesseract installation
RUN tesseract --version && \
    tesseract --list-langs

EXPOSE 8082

COPY target/services-0.0.1-SNAPSHOT.jar ocrService.jar

ENTRYPOINT ["java","-jar","ocrService.jar"]