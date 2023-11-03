package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsNote;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class DocumentsNoteRepositoryTest {
    @Autowired
    DocumentsNoteRepository documentsNoteRepository;

    @Test
    public void saveNote() {
        // Arrange
        OffsetDateTime offsetDT = OffsetDateTime.now();
        DocumentsNote documentsNote = new DocumentsNote();
        documentsNote.setNote("note testing");
        documentsNote.setCreated(offsetDT);

        // Act
        DocumentsNote savedNote = documentsNoteRepository.save(documentsNote);

        // Assert
        assertNotNull(savedNote);
        assertTrue(savedNote.getId() > 0);

        // clean up
        documentsNoteRepository.delete(savedNote);
    }

}
