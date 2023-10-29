package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupPermissionDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroupPermission;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AuthGroupPermissionMapperImpl.class})
class AuthGroupPermissionMapperTest {

    @Autowired
    AuthGroupPermissionMapper authGroupPermissionMapper;

    @Test
    public void dtoToEntity() {

        AuthGroupDto authGroupDto = new AuthGroupDto();
        authGroupDto.setName("ana");

        AuthGroupPermissionDto authGroupPermissionDto = new AuthGroupPermissionDto();
        authGroupPermissionDto.setGroup(authGroupDto);

        AuthGroupPermission authGroupPermission = authGroupPermissionMapper.convert(authGroupPermissionDto);

        assertEquals(authGroupPermissionDto.getGroup().getName(), authGroupPermission.getGroup().getName());
    }

    @Test
    public void entityToDto() {
        AuthGroup authGroup = new AuthGroup();
        authGroup.setName("ana");

        AuthGroupPermission authGroupPermission = new AuthGroupPermission();
        authGroupPermission.setGroup(authGroup);

        AuthGroupPermissionDto authGroupPermissionDto = authGroupPermissionMapper.convert(authGroupPermission);

        assertEquals(authGroupPermissionDto.getGroup().getName(), authGroupPermission.getGroup().getName());
    }

}