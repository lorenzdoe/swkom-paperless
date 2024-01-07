package at.fhtw.services.ocr;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/*
    * This class is used to test the OCRService class.
    * It uses a test.pdf file to test the OCR functionality.
    * It needs a valid Tesseract installation to work
 */

@SpringBootTest
public class OCRServiceTest {

    private OCRService ocrService;

    @Test
    public void testOCR() throws IOException {
        // Arrange
        ocrService = new OCRService();
        String filePath = "src/test/java/at/fhtw/services/ocr/test.pdf";
        FileInputStream input = new FileInputStream(filePath);
        MultipartFile file = new MockMultipartFile("test", "test.pdf", "application/pdf", input);

        // Act
        String result = ocrService.performOcr(file);

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("This is a test"));
    }
}