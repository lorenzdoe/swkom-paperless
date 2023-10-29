package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentTagDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumenttypeDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsTagDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumentTag;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumenttype;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsTag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsDocumenttypeMapperImpl.class})
class DocumentsDocumenttypeMapperTest {
    @Autowired
    DocumentsDocumenttypeMapper documentsDocumenttypeMapper;

    @Test
    public void dtoToEntity() {

        DocumentsDocumenttypeDto documentsDocumenttypeDto = new DocumentsDocumenttypeDto();
        documentsDocumenttypeDto.setName("amelie");

        DocumentsDocumenttype documentsDocumenttype = documentsDocumenttypeMapper.convert(documentsDocumenttypeDto);

        assertEquals(documentsDocumenttype.getName(), documentsDocumenttypeDto.getName());
    }

    @Test
    public void entityToDto() {
        DocumentsDocumenttype documentsDocumenttype = new DocumentsDocumenttype();
        documentsDocumenttype.setName("amelie");

        DocumentsDocumenttypeDto documentsDocumenttypeDto = documentsDocumenttypeMapper.convert(documentsDocumenttype);

        assertEquals(documentsDocumenttype.getName(), documentsDocumenttypeDto.getName());
    }
}