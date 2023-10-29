package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthUserDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthUserGroupDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.AuthUserGroup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AuthUserGroupMapperImpl.class})
class AuthUserGroupMapperTest {
    @Autowired
    AuthUserGroupMapper authUserGroupMapper;

    @Test
    public void dtoToEntity() {
        AuthUserDto userDto = new AuthUserDto();
        userDto.setFirstName("ana");

        AuthUserGroupDto authUserGroupDto = new AuthUserGroupDto();
        authUserGroupDto.setUser(userDto);

        AuthUserGroup authUserGroup = authUserGroupMapper.convert(authUserGroupDto);

        assertEquals(authUserGroupDto.getUser().getFirstName(), authUserGroup.getUser().getFirstName());
    }

    @Test
    public void entityToDtoAuth() {
        AuthUser user = new AuthUser();
        user.setFirstName("ana");

        AuthUserGroup authUserGroup = new AuthUserGroup();
        authUserGroup.setUser(user);

        AuthUserGroupDto authUserGroupDto = authUserGroupMapper.convert(authUserGroup);

        assertEquals(authUserGroupDto.getUser().getFirstName(), authUserGroup.getUser().getFirstName());
    }
}