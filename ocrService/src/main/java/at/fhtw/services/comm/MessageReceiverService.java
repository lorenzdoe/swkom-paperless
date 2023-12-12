package at.fhtw.services.comm;

import at.fhtw.persistance.DatabaseUpdater;
import at.fhtw.persistance.MinIORepository;
import at.fhtw.services.dto.Document;
import at.fhtw.services.elasticsearch.ElasticSearchService;
import at.fhtw.services.ocr.OCRService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.OffsetDateTime;

@Slf4j
@Service
public class MessageReceiverService {

    MinIORepository minioRepository;
    OCRService ocrService;

    DatabaseUpdater databaseUpdater;

    ElasticSearchService elasticSearchService;

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
            databaseUpdater.updateDocumentContentById(Integer.parseInt(id), ocrResult);

            // convert to document

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.registerModule(new JsonNullableModule());

            // fetch document data
            Document document = mapper.readValue( id, Document.class);            // System.out.println("OCR Result: " + ocrResult);
            document.setContent( JsonNullable.of(ocrResult));
            document.setModified(OffsetDateTime.now());

            try {
                elasticSearchService.indexDocument(document);
            } catch (IOException e) {
                log.error(e.getMessage());
            }

        } catch (Exception e) {
            log.error("Error processing OCR message: " + e.getMessage(), e);
        }
    }
}
