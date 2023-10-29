package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthUserDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthUserUserPermissionDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsUisettingDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.AuthUserUserPermission;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsUisetting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DocumentsUisettingMapperImpl.class})
class DocumentsUisettingMapperTest {
    @Autowired
    DocumentsUisettingMapper documentsUisettingMapper;

    @Test
    public void dtoToEntity() {

        AuthUserDto userDto = new AuthUserDto();
        userDto.setFirstName("ana");
        userDto.setLastName("matic");

        DocumentsUisettingDto documentsUisettingDto = new DocumentsUisettingDto();
        documentsUisettingDto.setUser(userDto);

        DocumentsUisetting documentsUisetting = documentsUisettingMapper.convert(documentsUisettingDto);

        assertEquals(documentsUisetting.getUser().getFirstName(), documentsUisettingDto.getUser().getFirstName());
        assertEquals(documentsUisetting.getUser().getLastName(), documentsUisettingDto.getUser().getLastName());

    }

    @Test
    public void entityToDtoAuth() {
        AuthUser user = new AuthUser();
        user.setFirstName("ana");
        user.setLastName("matic");

        DocumentsUisetting documentsUisetting = new DocumentsUisetting();
        documentsUisetting.setUser(user);

        DocumentsUisettingDto documentsUisettingDto = documentsUisettingMapper.convert(documentsUisetting);

        assertEquals(documentsUisetting.getUser().getFirstName(), documentsUisettingDto.getUser().getFirstName());
        assertEquals(documentsUisetting.getUser().getLastName(), documentsUisettingDto.getUser().getLastName());

    }
}