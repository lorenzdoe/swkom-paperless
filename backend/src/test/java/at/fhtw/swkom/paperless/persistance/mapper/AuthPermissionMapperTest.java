package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthPermissionDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.entities.AuthPermission;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AuthPermissionMapperImpl.class})
class AuthPermissionMapperTest {
    @Autowired
    AuthPermissionMapper authPermissionMapper;

    @Test
    public void dtoToEntity() {
        AuthPermissionDto authPermissionDto = new AuthPermissionDto();
        authPermissionDto.setName("ana");

        AuthPermission authPermission = authPermissionMapper.convert(authPermissionDto);

        assertEquals(authPermission.getName(), authPermissionDto.getName());
    }

    @Test
    public void entityToDto() {
        AuthPermission authPermission = new AuthPermission();
        authPermission.setName("ana");

        AuthPermissionDto authPermissionDto = authPermissionMapper.convert(authPermission);

        assertEquals(authPermission.getName(), authPermissionDto.getName());
    }
}