package at.fhtw.swkom.paperless.controller.documents;

import at.fhtw.swkom.paperless.controller.ApiUtil;
import at.fhtw.swkom.paperless.controller.documents.Documents;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import at.fhtw.swkom.paperless.persistance.mapper.DocumentsDocumentMapper;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.exceptions.UploadFileException;
import at.fhtw.swkom.paperless.services.impl.DocumentsDocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-18T10:19:48.387240Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class DocumentsController implements Documents {

    private final NativeWebRequest request;

    @Autowired
    public DocumentsController(NativeWebRequest request) {
        this.request = request;
    }

    @Autowired
    private DocumentsDocumentService documentsDocumentService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> uploadDocument(
            String title,
            OffsetDateTime created,
            Integer documentType,
            List<Integer> tags,
            Integer correspondent,
            List<MultipartFile> document
    ) {
        try {
            // all params except document are always null ( don't know why, don't know how to set them in frontend )
            // so I just pass the document to the service
            // the document contains information about name and type
            DocumentsDocumentDto documentsDocumentDto = documentsDocumentService.uploadFile(document);
            String response = "{\"task_id\": \"" + documentsDocumentDto.getId() + "\"}"; // needed for the progress bar to complete
            // tried to return task in response but doesnt change anything on progress bar
            // String task = "{\"id\":1,\"task_id\":\"fa2c4c82-e692-4612-afa3-7720fa2819ae\",\"task_file_name\":\"" + documentsDocumentDto.getTitle() + "\",\"date_created\":\"2023-09-08T12:04:53.631118Z\",\"date_done\":\"2023-09-08T12:05:30.021809Z\",\"type\":\"file\",\"status\":\"SUCCESS\",\"result\":\"Success. New document id 1 created\",\"acknowledged\":false,\"related_document\":\"1\"}";
            ApiUtil.setExampleResponse(request, "application/json", response);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (UploadFileException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}