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

            log.info("ocred: " + ocrResult);
            databaseUpdater.updateDocumentContentById(Integer.parseInt(id), ocrResult);

            Document document = new Document();
            document.setTitle(documentFile.getOriginalFilename());
            document.setContent(ocrResult);
            elasticSearchService.saveToElasticsearch(document);

            Document document1 = new Document();
            document1.setTitle("Title");
            document1.setContent("bla lorenz amelie ana");
            elasticSearchService.saveToElasticsearch(document1);

            Document document2 = new Document();
            document2.setTitle("bla");
            document2.setContent("mi u ovom trenutku bla");
            elasticSearchService.saveToElasticsearch(document2);

            Document document3 = new Document();
            document3.setTitle("dobra");
            document3.setContent("i ispravna politika");
            elasticSearchService.saveToElasticsearch(document3);

            List<Document> documentsList = elasticSearchService.search("bla");

            for (Document doc : documentsList) {
                System.out.println(doc.getTitle());
                System.out.println(doc.getContent());
                log.info(String.valueOf(doc.getTitle()));
                log.info(String.valueOf(doc.getContent()));
            }

            // System.out.println("OCR Result: " + ocrResult);

        } catch (Exception e) {
            log.error("Error processing OCR message: " + e.getMessage(), e);
        }
    }
}