package at.fhtw.swkom.paperless.persistance.repositories.MinIO;

import at.fhtw.swkom.paperless.persistance.repositories.exceptions.CouldNotDeleteFileException;
import at.fhtw.swkom.paperless.persistance.repositories.exceptions.CouldNotUploadFileException;
import at.fhtw.swkom.paperless.services.exceptions.BuildBucketFailException;
import io.minio.*;
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

    public void checkAndCreateBucket(String bucketName) throws BuildBucketFailException {
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
            throw new BuildBucketFailException("Bucket could not be build." + e);
        }
    }

    public void saveInputStream(String id, InputStream file, long size, String filetype) throws CouldNotUploadFileException {
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
            throw new CouldNotUploadFileException("MinIO could not upload file" + e);
        } finally {
            try {
                file.close();
            } catch (Exception e) {
                log.error("Could not close InputStream", e);
            }
        }
    }

    public void deleteFile(String string) throws CouldNotDeleteFileException {
        try {
            RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder()
                    .bucket(bucketName)
                    .object(string)
                    .build();
            minioClient.removeObject(removeObjectArgs);
            log.info("Successfully deleted '" + string + "' from bucket '" + bucketName + "'.");
        } catch (Exception e) {
            throw new CouldNotDeleteFileException("Could not delete file from MinIO" + e);
        }
    }
}
