package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumenttype;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsNote;
import at.fhtw.swkom.paperless.persistance.mapper.DocumentsNoteMapper;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class DocumentsDocumenttypeRepositoryTest {

    @Autowired
    DocumentsDocumenttypeRepository documentsDocumenttypeRepository;
    @Test
    public void saveNote() {
        DocumentsDocumenttype documentsDocumenttype = new DocumentsDocumenttype();
        documentsDocumenttype.setName("ana");
        documentsDocumenttype.setMatch("ana");
        documentsDocumenttype.setMatchingAlgorithm(3);
        documentsDocumenttype.setIsInsensitive(false);

        DocumentsDocumenttype savedDocument = documentsDocumenttypeRepository.save(documentsDocumenttype);

        assertNotNull(savedDocument);
        assertTrue(savedDocument.getId() > 0);
    }
}

