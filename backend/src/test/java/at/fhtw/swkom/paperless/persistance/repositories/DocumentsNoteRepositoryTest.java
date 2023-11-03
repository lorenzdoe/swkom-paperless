package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsNote;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class DocumentsNoteRepositoryTest {
    @Autowired
    DocumentsNoteRepository documentsNoteRepository;


    @Test
    public void saveNote() {
        OffsetDateTime offsetDT = OffsetDateTime.now();
        DocumentsNote documentsNote = new DocumentsNote();
        documentsNote.setNote("note testing");
        documentsNote.setCreated(offsetDT);
        DocumentsNote savedNote = documentsNoteRepository.save(documentsNote);

        assertNotNull(savedNote);
        assertTrue(savedNote.getId() > 0);
    }

}
