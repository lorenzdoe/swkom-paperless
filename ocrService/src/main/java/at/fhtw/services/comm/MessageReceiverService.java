package at.fhtw.services.comm;

import at.fhtw.persistance.DatabaseUpdater;
import at.fhtw.persistance.MinIORepository;
import at.fhtw.services.dto.Document;
//import at.fhtw.services.elasticsearch.ElasticSearchService;
import at.fhtw.services.elasticsearch.ElasticSearchService;
import at.fhtw.services.ocr.OCRService;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

@Slf4j
@Service
public class MessageReceiverService {

    MinIORepository minioRepository;
    OCRService ocrService;

    ElasticSearchService elasticSearchService;
    DatabaseUpdater databaseUpdater;

    public MessageReceiverService(@Autowired MinIORepository minioRepository, @Autowired OCRService ocrService, @Autowired DatabaseUpdater databaseUpdater, @Autowired ElasticSearchService elasticSearchService) {
        this.minioRepository = minioRepository;
        this.ocrService = ocrService;
        this.databaseUpdater = databaseUpdater;
        this.elasticSearchService = elasticSearchService;
    }

    @RabbitListener(queues = "paperless")
    public void receivedMessage(String id) {
        log.info("message from queue " + id);
        try {

            MultipartFile documentFile = minioRepository.getDocumentFile(id);
            String ocrResult = ocrService.performOcr(documentFile);
            String title = databaseUpdater.retrieveTitleFromDatabase(Integer.valueOf(id));

            log.info("documentFile name: " + documentFile.getName() + " documentFile original filename: " + documentFile.getOriginalFilename());
            log.info("ocred: " + ocrResult);
            databaseUpdater.updateDocumentContentById(Integer.parseInt(id), ocrResult);

            Document doc = new Document();
            doc.setId(Integer.parseInt(id));
            doc.setTitle( title );
            doc.setAdded(OffsetDateTime.now() );
            doc.setCreated(OffsetDateTime.now());
            doc.setArchivedFileName( JsonNullable.of(documentFile.getOriginalFilename()));
            doc.setOriginalFileName( JsonNullable.of(documentFile.getOriginalFilename()));
            doc.setContent( JsonNullable.of(ocrResult));

            log.info("ID in message rec: " + doc.getId());
            log.info("Content in message rec: " + doc.getContent());
            log.info("Title in message rec: " + doc.getTitle());

            // indexing
            try {
                elasticSearchService.indexDocument(doc);
            } catch (IOException e) {
                log.error(e.getMessage());
            }

        } catch (Exception e) {
            log.error("Error processing OCR message: " + e.getMessage(), e);
        }
    }
}