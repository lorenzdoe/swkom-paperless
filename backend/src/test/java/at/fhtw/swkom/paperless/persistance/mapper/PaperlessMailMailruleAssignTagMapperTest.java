package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentTagDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsTagDto;
import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailMailruleAssignTagDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumentTag;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsTag;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailruleAssignTag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PaperlessMailMailruleAssignTagMapperImpl.class})
class PaperlessMailMailruleAssignTagMapperTest {
    @Autowired
    PaperlessMailMailruleAssignTagMapper paperlessMailMailruleAssignTagMapper;

    @Test
    public void dtoToEntity() {
        DocumentsTagDto documentsTagDto = new DocumentsTagDto();
        documentsTagDto.setName("ana");

        PaperlessMailMailruleAssignTagDto paperlessMailMailruleAssignTagDto = new PaperlessMailMailruleAssignTagDto();
        paperlessMailMailruleAssignTagDto.setTag(documentsTagDto);

        PaperlessMailMailruleAssignTag paperlessMailMailruleAssignTag = paperlessMailMailruleAssignTagMapper.convert(paperlessMailMailruleAssignTagDto);

        assertEquals(paperlessMailMailruleAssignTag.getTag().getName(), paperlessMailMailruleAssignTagDto.getTag().getName());
    }

    @Test
    public void entityToDto() {
        DocumentsTag documentsTag = new DocumentsTag();
        documentsTag.setName("ana");

        PaperlessMailMailruleAssignTag paperlessMailMailruleAssignTag = new PaperlessMailMailruleAssignTag();
        paperlessMailMailruleAssignTag.setTag(documentsTag);

        PaperlessMailMailruleAssignTagDto paperlessMailMailruleAssignTagDto = paperlessMailMailruleAssignTagMapper.convert(paperlessMailMailruleAssignTag);

        assertEquals(paperlessMailMailruleAssignTag.getTag().getName(), paperlessMailMailruleAssignTagDto.getTag().getName());
    }
}