package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.repositories.DB.AuthGroupRepository;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes={OpenApiGeneratorApplication.class})
public class AuthGroupRepositoryTest {

    @Autowired
    AuthGroupRepository authGroupRepository;

    @Test
    public void testSaveAuthGroup() {
        // Arrange
        AuthGroup authGroup = new AuthGroup();
        authGroup.setName("test");

        // Act
        AuthGroup savedAuthGroup = authGroupRepository.save(authGroup);

        // Assert
        assertNotNull(savedAuthGroup);
        assertTrue(savedAuthGroup.getId() > 0);

        // clean up
        authGroupRepository.delete(savedAuthGroup);
    }
}