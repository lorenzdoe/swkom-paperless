package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumenttype;
import at.fhtw.swkom.paperless.persistance.repositories.DB.DocumentsDocumenttypeRepository;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class DocumentsDocumenttypeRepositoryTest {

    @Autowired
    DocumentsDocumenttypeRepository documentsDocumenttypeRepository;
    @Test
    public void saveNote() {
        // Arrange
        DocumentsDocumenttype documentsDocumenttype = new DocumentsDocumenttype();
        documentsDocumenttype.setName("ana");
        documentsDocumenttype.setMatch("ana");
        documentsDocumenttype.setMatchingAlgorithm(3);
        documentsDocumenttype.setIsInsensitive(false);

        // Act
        DocumentsDocumenttype savedDocument = documentsDocumenttypeRepository.save(documentsDocumenttype);

        // Assert
        assertNotNull(savedDocument);
        assertTrue(savedDocument.getId() > 0);

        // clean up
        documentsDocumenttypeRepository.delete(savedDocument);
    }
}

