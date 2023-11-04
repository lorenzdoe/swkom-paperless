package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsCorrespondent;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class DocumentsCorrespondentRepositoryTest{
    @Autowired
    DocumentsCorrespondentRepository documentsCorrespondentRepository;

    @Test
    public void testSaveCorrespondent(){
        DocumentsCorrespondent documentsCorrespondent = new DocumentsCorrespondent();
        documentsCorrespondent.setName("ana");
        documentsCorrespondent.setMatch("lorenz");
        documentsCorrespondent.setMatchingAlgorithm(2);
        documentsCorrespondent.setIsInsensitive(false);

        // Act
        DocumentsCorrespondent savedCorrespondent = documentsCorrespondentRepository.save(documentsCorrespondent);

        // Assert
        assertNotNull(savedCorrespondent);
        assertTrue(savedCorrespondent.getId() > 0);

        // clean up
        documentsCorrespondentRepository.delete(savedCorrespondent);
    }

}

