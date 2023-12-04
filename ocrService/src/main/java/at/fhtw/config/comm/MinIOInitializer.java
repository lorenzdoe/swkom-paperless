package at.fhtw.config.comm;

import at.fhtw.persistance.MinIORepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinIOInitializer {

    private final MinIORepository minIORepository;

    @Value("${minio.bucket.name}")
    private String bucketName;

    public MinIOInitializer(MinIORepository minIORepository) {
        this.minIORepository = minIORepository;
    }

    @PostConstruct
    public void init() {
        minIORepository.checkAndCreateBucket(bucketName);
    }
}
