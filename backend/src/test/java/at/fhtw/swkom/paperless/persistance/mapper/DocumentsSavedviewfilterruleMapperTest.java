package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsLogDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsSavedviewfilterruleDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsLog;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedviewfilterrule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsSavedviewfilterruleMapperImpl.class})
class DocumentsSavedviewfilterruleMapperTest {
    @Autowired
    DocumentsSavedviewfilterruleMapper documentsSavedviewfilterruleMapper;

    @Test
    public void dtoToEntity() {
        DocumentsSavedviewfilterruleDto documentsSavedviewfilterruleDto = new DocumentsSavedviewfilterruleDto();
        documentsSavedviewfilterruleDto.setValue("lorenz");

        DocumentsSavedviewfilterrule documentsSavedviewfilterrule = documentsSavedviewfilterruleMapper.convert(documentsSavedviewfilterruleDto);

        assertEquals(documentsSavedviewfilterrule.getValue(), documentsSavedviewfilterruleDto.getValue());
    }

    @Test
    public void entityToDto() {
        DocumentsSavedviewfilterrule documentsSavedviewfilterrule = new DocumentsSavedviewfilterrule();
        documentsSavedviewfilterrule.setValue("lorenz");

        DocumentsSavedviewfilterruleDto documentsSavedviewfilterruleDto = documentsSavedviewfilterruleMapper.convert(documentsSavedviewfilterrule);

        assertEquals(documentsSavedviewfilterrule.getValue(), documentsSavedviewfilterruleDto.getValue());
    }
}