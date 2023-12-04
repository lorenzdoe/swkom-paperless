package at.fhtw.persistance;

import io.minio.*;
import io.minio.errors.ErrorResponseException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Getter
@Repository
public class MinIORepository {

    private final MinioClient minioClient;

    @Value("${minio.bucket.name}")
    private String bucketName;

    @Autowired
    public MinIORepository(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    public void checkAndCreateBucket(String bucketName) {
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                // if bucket does not exist, create it
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                log.info("Bucket created successfully");
            } else {
                log.info("Bucket " + bucketName + "already exists");
            }
        } catch (Exception e) {
            log.error("Bucket does not exist and could not create bucket", e);
        }
    }

    public MultipartFile getDocumentFile(String id) {
        try {
            // Get metadata to retrieve content type
            StatObjectResponse statObjectResponse = minioClient.statObject(
                    StatObjectArgs.builder()
                            .bucket(bucketName)
                            .object(id)
                            .build()
            );

            // Fetch the content type from the metadata
            String contentType = statObjectResponse.contentType();

            try (InputStream stream = minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(id)
                            .build())) {

                // Create a MockMultipartFile object with the determined content type
                return new MockMultipartFile("file", id, contentType, stream);
            }
        } catch (ErrorResponseException e) {
            log.error("Error response from MinIO: " + e.getMessage(), e);
        } catch (IOException e) {
            log.error("Error reading stream or fetching metadata from MinIO: " + e.getMessage(), e);
        } catch (Exception e) {
            log.error("Error fetching document file from MinIO: " + e.getMessage(), e);
        }
        return null;
    }
}
