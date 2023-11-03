package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsStoragepath;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class DocumentsStoragepathRepositoryTest {

    @Autowired DocumentsStoragepathRepository documentsStoragepathRepository;

    @Test
    public void testSaveStoragepath() {
        // Arrange
        DocumentsStoragepath documentsStoragepath = new DocumentsStoragepath();
        documentsStoragepath.setName("test");
        documentsStoragepath.setMatch("test");
        documentsStoragepath.setPath("test");
        documentsStoragepath.setMatchingAlgorithm(3);
        documentsStoragepath.setIsInsensitive(false);

        // Act
        DocumentsStoragepath savedStoragepath = documentsStoragepathRepository.save(documentsStoragepath);

        // Assert
        assertNotNull(savedStoragepath);
        assertTrue(savedStoragepath.getId() > 0);

        // clean up
        documentsStoragepathRepository.delete(savedStoragepath);
    }
}