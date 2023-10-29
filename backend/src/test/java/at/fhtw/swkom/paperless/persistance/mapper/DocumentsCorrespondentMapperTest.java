package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsCorrespondentDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsCorrespondent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsCorrespondentMapperImpl.class})
class DocumentsCorrespondentMapperTest {
    @Autowired
    DocumentsCorrespondentMapper documentsCorrespondentMapper;

    @Test
    public void dtoToEntity() {
        DocumentsCorrespondentDto documentsCorrespondentDto = new DocumentsCorrespondentDto();
        documentsCorrespondentDto.setName("ana");

        DocumentsCorrespondent documentsCorrespondent = documentsCorrespondentMapper.convert(documentsCorrespondentDto);

        assertEquals(documentsCorrespondent.getName(), documentsCorrespondentDto.getName());
    }

    @Test
    public void entityToDto() {
        DocumentsCorrespondent documentsCorrespondent = new DocumentsCorrespondent();
        documentsCorrespondent.setName("ana");

        DocumentsCorrespondentDto documentsCorrespondentDto = documentsCorrespondentMapper.convert(documentsCorrespondent);

        assertEquals(documentsCorrespondent.getName(), documentsCorrespondentDto.getName());
    }
}