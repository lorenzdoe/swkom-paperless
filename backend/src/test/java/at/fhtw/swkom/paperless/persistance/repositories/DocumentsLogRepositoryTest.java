package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsCorrespondent;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsLog;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class DocumentsLogRepositoryTest{
    @Autowired
    DocumentsLogRepository documentsLogRepository;

    @Test
    public void testSaveLog(){

        OffsetDateTime offsetDT = OffsetDateTime.now();

        DocumentsLog documentsLog = new DocumentsLog();
        documentsLog.setMessage("ana");
        documentsLog.setLevel(6);
        documentsLog.setCreated(offsetDT);

        // Act
        DocumentsLog savedLog = documentsLogRepository.save(documentsLog);

        // Assert
        assertNotNull(savedLog);
        assertTrue(savedLog.getId() > 0);

        // clean up
        documentsLogRepository.delete(savedLog);
    }

}
