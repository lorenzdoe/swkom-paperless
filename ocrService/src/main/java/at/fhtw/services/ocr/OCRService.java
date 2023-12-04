package at.fhtw.services.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OCRService {
    public String performOcr(File imageFile) {
        Tesseract tesseract = new Tesseract();

        // Set Tesseract properties if needed
        tesseract.setDatapath("src/main/resources");
        tesseract.setLanguage("eng");
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);

        try {
            return tesseract.doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
            return "Error during OCR processing";
        }
    }
}
