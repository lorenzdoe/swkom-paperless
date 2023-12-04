package at.fhtw.services.comm;

import io.minio.*;
import io.minio.errors.ErrorResponseException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Getter
@Service
public class MinIOService {

    private final MinioClient minioClient;

    @Value("${minio.bucket.name}")
    private String bucketName;

    @Autowired
    public MinIOService(MinioClient minioClient) {
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

    public File getDocumentFile(String id) {
        try (InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object(id)
                        .build())) {

            return saveInputStreamToTempFile(stream);
        } catch (ErrorResponseException e) {
            System.out.println("Error response from MinIO" + e);
        } catch (IOException e) {
            System.out.println("Error reading stream from MinIO" + e);
        } catch (Exception e) {
            System.out.println("Error fetching document file from MinIO" + e);
        }

        return null;
    }

    private File saveInputStreamToTempFile(InputStream inputStream) throws IOException {
        File tempFile = File.createTempFile("minio_temp_", ".tmp");
        try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
        }
        return tempFile;
    }
}
