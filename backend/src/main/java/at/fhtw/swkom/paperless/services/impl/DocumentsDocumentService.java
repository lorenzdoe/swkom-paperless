package at.fhtw.swkom.paperless.services.impl;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import at.fhtw.swkom.paperless.persistance.mapper.DocumentsDocumentMapper;
import at.fhtw.swkom.paperless.persistance.repositories.DB.DocumentsDocumentRepository;
import at.fhtw.swkom.paperless.persistance.repositories.MinIO.MinIORepository;
import at.fhtw.swkom.paperless.persistance.repositories.exceptions.CouldNotDeleteFileException;
import at.fhtw.swkom.paperless.persistance.repositories.exceptions.CouldNotUploadFileException;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.exceptions.NoContentTypeSetException;
import at.fhtw.swkom.paperless.services.exceptions.NoFileTitleException;
import at.fhtw.swkom.paperless.services.exceptions.UploadFileException;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service

public class DocumentsDocumentService {
    private final DocumentsDocumentRepository documentsDocumentRepository;
    private final MinIORepository minIORepository;
    private final DocumentsDocumentMapper documentsDocumentMapper;

    @Autowired
    public DocumentsDocumentService(MinIORepository minIORepository,
                                    DocumentsDocumentRepository documentsDocumentRepository,
                                    DocumentsDocumentMapper documentsDocumentMapper) {
        this.minIORepository = minIORepository;
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
                    .content("")
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
                if(Objects.requireNonNull(file.getOriginalFilename()).isEmpty()){
                    throw new NoFileTitleException("Error: the file has no Title.");
                }
                if(Objects.requireNonNull(file.getContentType()).isEmpty()){
                    throw new NoContentTypeSetException("Error: there is no content type set for this file.");
                }
                minIORepository.saveInputStream(saved.getId().toString(), file.getInputStream(), file.getSize(), filetype);
            }
            return savedDto;

        } catch (CouldNotUploadFileException e) {
            log.error("Error when trying to upload file to MinIO", e);
            throw new UploadFileException("Could not store file. Please try again!");
        } catch (Exception e) {
            log.error("Error when trying to upload file", e);
            throw new UploadFileException("Could not store file. Please try again!");
        }
    }

    public void deleteDocumentById(Integer id) throws CouldNotDeleteFileException {
        documentsDocumentRepository.deleteById(Long.valueOf(id));
        minIORepository.deleteFile(id.toString());
    }

    public DocumentsDocumentDto getDocumentById(Integer id) {
        DocumentsDocument document = documentsDocumentRepository.findById(Long.valueOf(id)).orElse(null);
        return documentsDocumentMapper.convert(document);
    }

    public List<Document> getAllDocuments() {
        List<DocumentsDocument> documents = documentsDocumentRepository.findAll();
        List<Document> documentList = new ArrayList<>();
        for (DocumentsDocument document : documents) {
            Document documentDto = new Document();
            documentDto.setId(document.getId().intValue());
            documentDto.setTitle(JsonNullable.of(document.getTitle()));
            documentDto.setCreated(document.getAdded());
            documentDto.setModified(document.getModified());
            documentDto.setAdded(document.getAdded());
            documentDto.setContent(JsonNullable.of(document.getContent()));
            documentList.add(documentDto);
        }
        return documentList;
    }
}