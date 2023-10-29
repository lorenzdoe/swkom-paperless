package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentTagDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsTagDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumentTag;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsTag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsDocumentTagMapperImpl.class})
class DocumentsDocumentTagMapperTest {
    @Autowired
    DocumentsDocumentTagMapper documentsDocumentTagMapper;

    @Test
    public void dtoToEntity() {
        DocumentsTagDto documentsTagDto = new DocumentsTagDto();
        documentsTagDto.setName("ana");

        DocumentsDocumentTagDto documentsDocumentTagDto = new DocumentsDocumentTagDto();
        documentsDocumentTagDto.setTag(documentsTagDto);

        DocumentsDocumentTag documentsDocumentTag = documentsDocumentTagMapper.convert(documentsDocumentTagDto);

        assertEquals(documentsDocumentTag.getTag().getName(), documentsDocumentTagDto.getTag().getName());
    }

    @Test
    public void entityToDto() {
        DocumentsTag documentsTag = new DocumentsTag();
        documentsTag.setName("ana");

        DocumentsDocumentTag documentsDocumentTag = new DocumentsDocumentTag();
        documentsDocumentTag.setTag(documentsTag);

        DocumentsDocumentTagDto documentsDocumentTagDto = documentsDocumentTagMapper.convert(documentsDocumentTag);

        assertEquals(documentsDocumentTag.getTag().getName(), documentsDocumentTagDto.getTag().getName());
    }
}