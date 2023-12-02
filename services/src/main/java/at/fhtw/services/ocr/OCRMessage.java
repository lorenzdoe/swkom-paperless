package at.fhtw.services.ocr;

import at.fhtw.services.comm.MinIOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Slf4j
public class OCRMessage {
    @Autowired
    private OCRService ocrService;

    @Autowired
    private MinIOService minioService;

    @RabbitListener(queues = {"paperless"})
    public void receiveMessage(String message) {
        log.info("OCR receiving message from RabbitMQ with message: " + message);

        try {
            log.info("receiving in try: " + message);

            String documentId = extractDocumentIdFromJson(message);

            File documentFile = minioService.getDocumentFile(documentId);

            String ocrResult = ocrService.performOcr(documentFile);

            System.out.println("OCR Result: " + ocrResult);

        } catch (Exception e) {
            log.error("Error processing OCR message: " + e.getMessage(), e);
        }
    }

    private String extractDocumentIdFromJson(String jsonMessage) {
        int startIndex = jsonMessage.indexOf("\"id\": \"") + "\"id\": \"".length();
        int endIndex = jsonMessage.indexOf("\"", startIndex);
        return jsonMessage.substring(startIndex, endIndex);
    }
}
