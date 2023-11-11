package at.fhtw.swkom.paperless.config;

import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MinIOConfiguration {

    @Value("${minio.access.name}")
    private String accessKey;
    @Value("${minio.access.secret}")
    private String secretSecret;
    @Value("${minio.url}")
    private String url;

    @Bean
    public MinioClient minioClient() {
        try{
            MinioClient mc = MinioClient.builder()
                    .endpoint(url)
                    .credentials(accessKey, secretSecret)
                    .build();
            log.info("MinIO client initialized, url: {}", url);
            return mc;
        } catch (Exception e) {
            throw new RuntimeException("Could not initialize MinIO client", e);
        }
    }
}
