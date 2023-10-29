package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsCorrespondentDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsCorrespondent;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsDocumentMapperImpl.class})
class DocumentsDocumentMapperTest {
    @Autowired
    DocumentsDocumentMapper documentsDocumentMapper;

    @Test
    public void dtoToEntity() {
        DocumentsDocumentDto documentsDocumentDto = new DocumentsDocumentDto();
        documentsDocumentDto.setTitle("ana");

        DocumentsDocument documentsDocument = documentsDocumentMapper.convert(documentsDocumentDto);

        assertEquals(documentsDocument.getTitle(), documentsDocumentDto.getTitle());
    }

    @Test
    public void entityToDto() {
        DocumentsDocument documentsDocument = new DocumentsDocument();
        documentsDocument.setTitle("ana");

        DocumentsDocumentDto documentsDocumentDto = documentsDocumentMapper.convert(documentsDocument);

        assertEquals(documentsDocument.getTitle(), documentsDocumentDto.getTitle());
    }
}