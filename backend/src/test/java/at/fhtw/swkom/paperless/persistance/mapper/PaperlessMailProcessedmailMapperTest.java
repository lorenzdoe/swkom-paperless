package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailMailruleDto;
import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailProcessedmailDto;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailrule;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailProcessedmail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PaperlessMailProcessedmailMapperImpl.class})
class PaperlessMailProcessedmailMapperTest {
    @Autowired
    PaperlessMailProcessedmailMapper paperlessMailProcessedmailMapper;

    @Test
    public void dtoToEntity() {
        PaperlessMailProcessedmailDto paperlessMailProcessedmailDto = new PaperlessMailProcessedmailDto();
        paperlessMailProcessedmailDto.setFolder("lorenz");

        PaperlessMailProcessedmail paperlessMailProcessedmail = paperlessMailProcessedmailMapper.convert(paperlessMailProcessedmailDto);

        assertEquals(paperlessMailProcessedmail.getFolder(), paperlessMailProcessedmailDto.getFolder());
    }

    @Test
    public void entityToDto() {
        PaperlessMailProcessedmail paperlessMailProcessedmail = new PaperlessMailProcessedmail();
        paperlessMailProcessedmail.setFolder("lorenz");

        PaperlessMailProcessedmailDto paperlessMailProcessedmailDto = paperlessMailProcessedmailMapper.convert(paperlessMailProcessedmail);

        assertEquals(paperlessMailProcessedmail.getFolder(), paperlessMailProcessedmailDto.getFolder());
    }
}