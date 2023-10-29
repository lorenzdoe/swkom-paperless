package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthUserDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthUserUserPermissionDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.AuthUserUserPermission;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AuthUserUserPermissionMapperImpl.class})
class AuthUserUserPermissionMapperTest {
    @Autowired
    AuthUserUserPermissionMapper authUserUserPermissionMapper;

    @Test
    public void dtoToEntity() {

        AuthUserDto userDto = new AuthUserDto();
        userDto.setFirstName("ana");
        userDto.setLastName("matic");

        AuthUserUserPermissionDto authUserUserPermissionDto = new AuthUserUserPermissionDto();
        authUserUserPermissionDto.setUser(userDto);

        AuthUserUserPermission authUserUserPermission = authUserUserPermissionMapper.convert(authUserUserPermissionDto);

        assertEquals(authUserUserPermission.getUser().getFirstName(), authUserUserPermissionDto.getUser().getFirstName());
        assertEquals(authUserUserPermission.getUser().getLastName(), authUserUserPermissionDto.getUser().getLastName());

    }

    @Test
    public void entityToDtoAuth() {
        AuthUser user = new AuthUser();
        user.setFirstName("ana");
        user.setLastName("matic");

        AuthUserUserPermission authUserUserPermission = new AuthUserUserPermission();
        authUserUserPermission.setUser(user);

        AuthUserUserPermissionDto authUserUserPermissionDto = authUserUserPermissionMapper.convert(authUserUserPermission);

        assertEquals(authUserUserPermission.getUser().getFirstName(), authUserUserPermissionDto.getUser().getFirstName());
        assertEquals(authUserUserPermission.getUser().getLastName(), authUserUserPermissionDto.getUser().getLastName());
    }
}