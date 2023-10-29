package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsNoteDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsPaperlesstaskDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsNote;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsPaperlesstask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsPaperlesstaskMapperImpl.class})
class DocumentsPaperlesstaskMapperTest {
    @Autowired
    DocumentsPaperlesstaskMapper documentsPaperlesstaskMapper;

    @Test
    public void dtoToEntity() {
        DocumentsPaperlesstaskDto documentsPaperlesstaskDto = new DocumentsPaperlesstaskDto();
        documentsPaperlesstaskDto.setTaskName("lorenz");

        DocumentsPaperlesstask documentsPaperlesstask = documentsPaperlesstaskMapper.convert(documentsPaperlesstaskDto);

        assertEquals(documentsPaperlesstask.getTaskName(), documentsPaperlesstaskDto.getTaskName());
    }

    @Test
    public void entityToDto() {
        DocumentsPaperlesstask documentsPaperlesstask = new DocumentsPaperlesstask();
        documentsPaperlesstask.setTaskName("lorenz");

        DocumentsPaperlesstaskDto documentsPaperlesstaskDto = documentsPaperlesstaskMapper.convert(documentsPaperlesstask);

        assertEquals(documentsPaperlesstask.getTaskName(), documentsPaperlesstaskDto.getTaskName());
    }
}