package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsTagDto;
import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailMailruleDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsTag;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailrule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PaperlessMailMailruleMapperImpl.class})
class PaperlessMailMailruleMapperTest {
    @Autowired
    PaperlessMailMailruleMapper paperlessMailMailruleMapper;

    @Test
    public void dtoToEntity() {
        PaperlessMailMailruleDto paperlessMailMailruleDto = new PaperlessMailMailruleDto();
        paperlessMailMailruleDto.setName("lorenz");

        PaperlessMailMailrule paperlessMailMailrule = paperlessMailMailruleMapper.convert(paperlessMailMailruleDto);

        assertEquals(paperlessMailMailrule.getName(), paperlessMailMailruleDto.getName());
    }

    @Test
    public void entityToDto() {
        PaperlessMailMailrule paperlessMailMailrule = new PaperlessMailMailrule();
        paperlessMailMailrule.setName("lorenz");

        PaperlessMailMailruleDto paperlessMailMailruleDto = paperlessMailMailruleMapper.convert(paperlessMailMailrule);

        assertEquals(paperlessMailMailrule.getName(), paperlessMailMailruleDto.getName());
    }
}