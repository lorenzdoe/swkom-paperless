package at.fhtw.swkom.paperless.config;

import at.fhtw.swkom.paperless.services.MinIOService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinIOInitializer {

    private final MinIOService minIOService;

    @Value("${minio.bucket.name}")
    private String bucketName;

    public MinIOInitializer(MinIOService minIOService) {
        this.minIOService = minIOService;
    }

    @PostConstruct
    public void init() {
        minIOService.checkAndCreateBucket(bucketName);
    }
}
