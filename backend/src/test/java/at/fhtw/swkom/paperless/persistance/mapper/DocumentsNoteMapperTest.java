package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsLogDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsNoteDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsLog;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsNote;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsNoteMapperImpl.class})
class DocumentsNoteMapperTest {
    @Autowired
    DocumentsNoteMapper documentsNoteMapper;

    @Test
    public void dtoToEntity() {
        DocumentsNoteDto documentsNoteDto = new DocumentsNoteDto();
        documentsNoteDto.setNote("hello mapper");

        DocumentsNote documentsNote = documentsNoteMapper.convert(documentsNoteDto);

        assertEquals(documentsNote.getNote(), documentsNoteDto.getNote());
    }

    @Test
    public void entityToDto() {
        DocumentsNote documentsNote = new DocumentsNote();
        documentsNote.setNote("hello mapper");

        DocumentsNoteDto documentsNoteDto = documentsNoteMapper.convert(documentsNote);

        assertEquals(documentsNote.getNote(), documentsNoteDto.getNote());
    }
}