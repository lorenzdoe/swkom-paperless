package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AuthGroupMapperImpl.class})
class AuthGroupMapperTest {
    @Autowired
    AuthGroupMapper authGroupMapper;

    @Test
    public void dtoToEntityAuthGroup() {
        AuthGroupDto authGroupDto = new AuthGroupDto();
        authGroupDto.setName("ana");

        AuthGroup authGroup = authGroupMapper.convert(authGroupDto);

        assertEquals(authGroupDto.getName(), authGroup.getName());
    }

    @Test
    public void entityToDtoAuthGroup() {
        AuthGroup authGroup = new AuthGroup();
        authGroup.setName("ana");

        AuthGroupDto authGroupDto = authGroupMapper.convert(authGroup);

        assertEquals(authGroupDto.getName(), authGroup.getName());
    }
}