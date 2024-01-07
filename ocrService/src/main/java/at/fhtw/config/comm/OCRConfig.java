package at.fhtw.config.comm;

import at.fhtw.services.ocr.OCRService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OCRConfig {
    @Bean
    public OCRService ocrService() {
        return new OCRService();
    }
}
