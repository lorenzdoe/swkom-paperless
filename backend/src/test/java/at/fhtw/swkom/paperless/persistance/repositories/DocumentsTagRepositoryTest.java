package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsTag;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class DocumentsTagRepositoryTest {

    @Autowired
    DocumentsTagRepository documentsTagRepository;

    @Test
    public void saveTagTest() {
        // Arrange
        DocumentsTag documentsTag = new DocumentsTag();
        documentsTag.setName("lui");
        documentsTag.setMatch("liu");
        documentsTag.setMatchingAlgorithm(3);
        documentsTag.setIsInsensitive(false);
        documentsTag.setColor("red");

        // Act
        DocumentsTag savedDocumentTag = documentsTagRepository.save(documentsTag);

        // Assert
        assertNotNull(savedDocumentTag);
        assertTrue(savedDocumentTag.getId() > 0);

        // clean up
        documentsTagRepository.delete(savedDocumentTag);
    }
}