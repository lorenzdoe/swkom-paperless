package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsLog;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsPaperlesstask;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class DocumentsPaperlesstaskRepositoryTest{
    @Autowired
    DocumentsPaperlesstaskRepository documentsPaperlesstaskRepository;

    @Test
    public void testSaveTask(){

        DocumentsPaperlesstask documentsPaperlesstask = new DocumentsPaperlesstask();
        documentsPaperlesstask.setTaskId("amelie");
        documentsPaperlesstask.setAcknowledged(false);
        documentsPaperlesstask.setStatus("lorenz");

        // Act
        DocumentsPaperlesstask saveTask = documentsPaperlesstaskRepository.save(documentsPaperlesstask);

        // Assert
        assertNotNull(saveTask);
        assertTrue(saveTask.getId() > 0);

        // clean up
        documentsPaperlesstaskRepository.delete(saveTask);
    }

}