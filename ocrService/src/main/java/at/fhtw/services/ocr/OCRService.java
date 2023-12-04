package at.fhtw.services.ocr;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class OCRService {

    @Value("${tesseract.path}")
    private String TESSERACT_DATA_PATH;

    public String performOcr(MultipartFile file) {
        try {
            PDDocument document = Loader.loadPDF(file.getBytes());
            String strippedText = extractTextFromScannedDocument(document);

            JSONObject obj = new JSONObject();
            obj.put("fileName", file.getOriginalFilename());
            obj.put("text", strippedText);

            log.info("OCR Result: " + obj.toString());
            return obj.toString();

        } catch (Exception e) {
            log.error("Error during OCR processing", e);
            return "Error during OCR processing";
        }
    }

    private String extractTextFromScannedDocument(PDDocument document)
            throws IOException, TesseractException {

        // Extract images from file
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        StringBuilder out = new StringBuilder();

        ITesseract _tesseract = new Tesseract();
        _tesseract.setDatapath(TESSERACT_DATA_PATH);
        _tesseract.setLanguage("eng");

        for (int page = 0; page < document.getNumberOfPages(); page++)
        {
            BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);

            // Create a temp image file
            File temp = File.createTempFile("tempfile_" + page, ".png");
            ImageIO.write(bim, "png", temp);

            String result = _tesseract.doOCR(temp);
            out.append(result);

            // Delete temp file
            temp.delete();

        }

        return out.toString();

    }
}
