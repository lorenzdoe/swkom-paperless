package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsSavedviewDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsTagDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedview;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsTag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsTagMapperImpl.class})
class DocumentsTagMapperTest {
    @Autowired
    DocumentsTagMapper documentsTagMapper;

    @Test
    public void dtoToEntity() {
        DocumentsTagDto documentsTagDto = new DocumentsTagDto();
        documentsTagDto.setName("amelie");

        DocumentsTag documentsTag = documentsTagMapper.convert(documentsTagDto);

        assertEquals(documentsTag.getName(), documentsTagDto.getName());
    }

    @Test
    public void entityToDto() {
        DocumentsTag documentsTag = new DocumentsTag();
        documentsTag.setName("amelie");

        DocumentsTagDto documentsTagDto = documentsTagMapper.convert(documentsTag);

        assertEquals(documentsTag.getName(), documentsTagDto.getName());
    }
}