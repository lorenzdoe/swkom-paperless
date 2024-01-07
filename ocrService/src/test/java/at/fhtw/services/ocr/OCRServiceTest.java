package at.fhtw.services.ocr;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OCRServiceTest {
    private OCRService ocrService;

    public OCRServiceTest(@Autowired OCRService ocrService) {
        this.ocrService = ocrService;
    }

    @Test
    public void testOCR() {
        MockMultipartFile file = new MockMultipartFile("test.png", "test.png", "image/png", "Hello World".getBytes());
        // String result = ocrService.performOcr("src/test/resources/test.png");
        // assertEquals("Hello World", result);
    }
}