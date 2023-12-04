package at.fhtw.services.comm;

import at.fhtw.persistance.DatabaseUpdater;
import at.fhtw.persistance.MinIORepository;
import at.fhtw.services.ocr.OCRService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class MessageReceiverService {

    MinIORepository minioRepository;
    OCRService ocrService;

    DatabaseUpdater databaseUpdater;

    public MessageReceiverService(@Autowired MinIORepository minioRepository, @Autowired OCRService ocrService, @Autowired DatabaseUpdater databaseUpdater) {
        this.minioRepository = minioRepository;
        this.ocrService = ocrService;
        this.databaseUpdater = databaseUpdater;
    }

    @RabbitListener(queues = "paperless")
    public void receivedMessage(String id) {
        log.info("message from queue " + id);
        try {

            MultipartFile documentFile = minioRepository.getDocumentFile(id);
            String ocrResult = ocrService.performOcr(documentFile);
            databaseUpdater.updateDocumentContentById(Integer.parseInt(id), ocrResult);

            // System.out.println("OCR Result: " + ocrResult);

        } catch (Exception e) {
            log.error("Error processing OCR message: " + e.getMessage(), e);
        }
    }
}
