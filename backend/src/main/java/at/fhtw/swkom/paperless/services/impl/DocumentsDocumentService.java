package at.fhtw.swkom.paperless.services.impl;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import at.fhtw.swkom.paperless.persistance.mapper.DocumentsDocumentMapper;
import at.fhtw.swkom.paperless.persistance.repositories.DocumentsDocumentRepository;
import at.fhtw.swkom.paperless.services.comm.MinIOService;
import at.fhtw.swkom.paperless.services.exceptions.UploadFileException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class DocumentsDocumentService {
    private final DocumentsDocumentRepository documentsDocumentRepository;
    private final MinIOService minIOService;
    private final DocumentsDocumentMapper documentsDocumentMapper;

    @Autowired
    public DocumentsDocumentService(MinIOService minIOService,
                                    DocumentsDocumentRepository documentsDocumentRepository,
                                    DocumentsDocumentMapper documentsDocumentMapper) {
        this.minIOService = minIOService;
        this.documentsDocumentRepository = documentsDocumentRepository;
        this.documentsDocumentMapper = documentsDocumentMapper;
    }

    public DocumentsDocumentDto uploadFile(List<MultipartFile> document) throws UploadFileException {
        try {
            // all @NotNull members of DocumentsDocumentDto
            String filename = document.get(0).getOriginalFilename();        // title
            String filetype = document.get(0).getContentType();             // mimeType
            String content = Arrays.toString(document.get(0).getBytes());   // content (?)
            OffsetDateTime created = OffsetDateTime.now();                  // created
            OffsetDateTime added = OffsetDateTime.now();                    // added
            OffsetDateTime modified = OffsetDateTime.now();                 // modified
            String checksum = String.valueOf(Arrays.hashCode(document.get(0).getBytes())); // checksum
            String storageType = "local";                                   // storageType

            DocumentsDocumentDto documentsDocumentDto = DocumentsDocumentDto.builder()
                    .title(filename)
                    .mimeType(filetype)
                    .content(content)
                    .created(created)
                    .added(added)
                    .modified(modified)
                    .checksum(checksum)
                    .storageType(storageType)
                    .build();

            DocumentsDocument entity = documentsDocumentMapper.convert(documentsDocumentDto);
            DocumentsDocument saved = documentsDocumentRepository.save(entity);
            DocumentsDocumentDto savedDto = documentsDocumentMapper.convert(saved);

            if (saved.getId() == null) {
                throw new UploadFileException("Could not store file. Please try again!");
            }

            log.info("Saved document with id {}", saved.getId());
            for (MultipartFile file : document) {
                log.info("File name: {}", file.getOriginalFilename());
                log.info("File size: {}", file.getSize());
                log.info("File type: {}", file.getContentType());
                minIOService.saveInputStream(saved.getId().toString(), file.getInputStream(), file.getSize(), filetype);
            }
            return savedDto;

        } catch (Exception e) {
            log.error("Error when trying to upload file to MinIO", e);
            throw new UploadFileException("Could not store file. Please try again!");
        }
    }

}