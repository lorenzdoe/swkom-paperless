package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsLogDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsLog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsLogMapperImpl.class})
class DocumentsLogMapperTest {
    @Autowired
    DocumentsLogMapper documentsLogMapper;

    @Test
    public void dtoToEntity() {
        DocumentsLogDto documentsLogDto = new DocumentsLogDto();
        documentsLogDto.setMessage("hello mapper");

        DocumentsLog documentsLog = documentsLogMapper.convert(documentsLogDto);

        assertEquals(documentsLog.getMessage(), documentsLogDto.getMessage());
    }

    @Test
    public void entityToDto() {
        DocumentsLog documentsLog = new DocumentsLog();
        documentsLog.setMessage("hello mapper");

        DocumentsLogDto documentsLogDto = documentsLogMapper.convert(documentsLog);

        assertEquals(documentsLog.getMessage(), documentsLogDto.getMessage());
    }
}