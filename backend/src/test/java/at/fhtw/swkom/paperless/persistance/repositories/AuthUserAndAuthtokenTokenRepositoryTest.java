package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.AuthtokenToken;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class AuthUserAndAuthtokenTokenRepositoryTest {

    @Autowired
    AuthtokenTokenRepository authtokenTokenRepository;
    @Autowired
    AuthUserRepository authUserRepository;

    // token needs user to be saved
    @Test
    public void testSaveAuthToken() {
        //////////// AuthUser
        // Arrange
        OffsetDateTime offsetDT = OffsetDateTime.now();
        AuthUser authUser = new AuthUser();
        authUser.setUsername("test");
        authUser.setIsSuperuser(false);
        authUser.setIsStaff(false);
        authUser.setIsActive(true);
        authUser.setLastLogin(offsetDT);
        authUser.setDateJoined(offsetDT);
        authUser.setPassword("test");
        authUser.setFirstName("test");
        authUser.setLastName("test");
        authUser.setEmail("adsf@email.com");

        // Act
        AuthUser savedUser = authUserRepository.save(authUser);

        // Assert
        assertNotNull(savedUser);
        assertTrue(savedUser.getId() > 0);

        //////////// AuthtokenToken
        // Arrange
        AuthtokenToken authtokenToken = new AuthtokenToken();
        authtokenToken.setKey("key");
        authtokenToken.setCreated(offsetDT);
        authtokenToken.setUser(savedUser);

        // Act
        AuthtokenToken savedAuthToken = authtokenTokenRepository.save(authtokenToken);

        // Assert
        assertNotNull(savedAuthToken);
        assertEquals("key", savedAuthToken.getKey());

        // clean up
        authtokenTokenRepository.delete(savedAuthToken);
        authUserRepository.delete(savedUser);

    }
}