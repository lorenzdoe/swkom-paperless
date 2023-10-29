package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsLogDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsSavedviewDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsLog;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedview;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsSavedviewMapperImpl.class})
class DocumentsSavedviewMapperTest {
    @Autowired
    DocumentsSavedviewMapper documentsSavedviewMapper;

    @Test
    public void dtoToEntity() {
        DocumentsSavedviewDto documentsSavedviewDto = new DocumentsSavedviewDto();
        documentsSavedviewDto.setName("amelie");

        DocumentsSavedview documentsSavedview = documentsSavedviewMapper.convert(documentsSavedviewDto);

        assertEquals(documentsSavedview.getName(), documentsSavedviewDto.getName());
    }

    @Test
    public void entityToDto() {
        DocumentsSavedview documentsSavedview = new DocumentsSavedview();
        documentsSavedview.setName("amelie");

        DocumentsSavedviewDto documentsSavedviewDto = documentsSavedviewMapper.convert(documentsSavedview);

        assertEquals(documentsSavedview.getName(), documentsSavedviewDto.getName());
    }
}