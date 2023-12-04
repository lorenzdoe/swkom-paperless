package at.fhtw.swkom.paperless.persistance.repositories.MinIO;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

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

    public void saveInputStream(String id, InputStream file, long size, String filetype) {
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(id)
                            .stream(file, size, -1) // size is the size of the InputStream, -1 indicates unknown size
                            .contentType(filetype)
                            .build()
            );
            log.info("Successfully uploaded '" + id + "' to bucket '" + bucketName + "'.");
        } catch (Exception e) {
            log.error("Could not upload file to MinIO", e);
        } finally {
            try {
                file.close();
            } catch (Exception e) {
                log.error("Could not close InputStream", e);
            }
        }
    }
}