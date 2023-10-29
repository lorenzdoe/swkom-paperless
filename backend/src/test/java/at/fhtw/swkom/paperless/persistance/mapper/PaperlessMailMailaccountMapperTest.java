package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsSavedviewDto;
import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailMailaccountDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedview;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailaccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PaperlessMailMailaccountMapperImpl.class})
class PaperlessMailMailaccountMapperTest {
    @Autowired
    PaperlessMailMailaccountMapper paperlessMailMailaccountMapper;

    @Test
    public void dtoToEntity() {
        PaperlessMailMailaccountDto paperlessMailMailaccountDto = new PaperlessMailMailaccountDto();
        paperlessMailMailaccountDto.setName("amelie");

        PaperlessMailMailaccount paperlessMailMailaccount = paperlessMailMailaccountMapper.convert(paperlessMailMailaccountDto);

        assertEquals(paperlessMailMailaccount.getName(), paperlessMailMailaccountDto.getName());
    }

    @Test
    public void entityToDto() {
        PaperlessMailMailaccount paperlessMailMailaccount = new PaperlessMailMailaccount();
        paperlessMailMailaccount.setName("amelie");

        PaperlessMailMailaccountDto paperlessMailMailaccountDto = paperlessMailMailaccountMapper.convert(paperlessMailMailaccount);

        assertEquals(paperlessMailMailaccount.getName(), paperlessMailMailaccountDto.getName());
    }
}