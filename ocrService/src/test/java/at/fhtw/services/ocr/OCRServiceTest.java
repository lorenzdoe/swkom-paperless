package at.fhtw.services.ocr;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OCRServiceTest {

    @Autowired
    private OCRService ocrService;

    @Test
    public void testOCR() {
        // Arrange
        String filePath = "src/test/java/at/fhtw/services/ocr/test.pdf";
        MockMultipartFile file = new MockMultipartFile("test.pdf", filePath, "application/pdf", "test".getBytes());

    }
}