package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthUserDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthUserGroupDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.AuthUserGroup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AuthUserMapperImpl.class})
class AuthUserMapperTest {
    @Autowired
    AuthUserMapper authUserMapper;

    @Test
    public void dtoToEntity() {
        AuthUserDto userDto = new AuthUserDto();
        userDto.setFirstName("ana");
        userDto.setLastName("matic");

        AuthUser user = authUserMapper.convert(userDto);

        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getLastName(), userDto.getLastName());

    }

    @Test
    public void entityToDtoAuth() {
        AuthUser user = new AuthUser();
        user.setFirstName("ana");
        user.setLastName("matic");

        AuthUserDto userDto = authUserMapper.convert(user);

        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getLastName(), userDto.getLastName());
    }
}