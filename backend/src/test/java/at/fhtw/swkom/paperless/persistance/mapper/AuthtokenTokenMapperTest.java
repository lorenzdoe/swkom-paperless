package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthtokenTokenDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.entities.AuthtokenToken;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AuthtokenTokenMapperImpl.class})
class AuthtokenTokenMapperTest {
    @Autowired
    AuthtokenTokenMapper authtokenTokenMapper;

    @Test
    public void dtoToEntity() {
        AuthtokenTokenDto authtokenTokenDto = new AuthtokenTokenDto();
        authtokenTokenDto.setKey("ana");

        AuthtokenToken authtokenToken = authtokenTokenMapper.convert(authtokenTokenDto);

        assertEquals(authtokenToken.getKey(), authtokenTokenDto.getKey());
    }

    @Test
    public void entityToDto() {
        AuthtokenToken authtokenToken = new AuthtokenToken();
        authtokenToken.setKey("ana");

        AuthtokenTokenDto authtokenTokenDto = authtokenTokenMapper.convert(authtokenToken);

        assertEquals(authtokenToken.getKey(), authtokenTokenDto.getKey());
    }
}