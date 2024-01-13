package at.fhtw.swkom.paperless.controller.documents;

import at.fhtw.swkom.paperless.controller.ApiUtil;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsCorrespondent;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import at.fhtw.swkom.paperless.persistance.repositories.MinIO.MinIORepository;
import at.fhtw.swkom.paperless.persistance.repositories.exceptions.CouldNotDeleteFileException;
import at.fhtw.swkom.paperless.services.comm.MessageService;
import at.fhtw.swkom.paperless.services.dto.*;
import at.fhtw.swkom.paperless.services.elasticsearch.ElasticSearchService;
import at.fhtw.swkom.paperless.services.exceptions.UploadFileException;
import at.fhtw.swkom.paperless.services.impl.DocumentsDocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Autowired
    ElasticSearchService elasticSearchService;

    @Autowired
    private MessageService messageService;
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<GetDocument200Response> getDocument(Integer id, Integer page, Boolean full_perms) {
        log.info("getDocument Request: id=" + id);
        DocumentsDocumentDto document = documentsDocumentService.getDocumentById(id);
        GetDocument200Response response = new GetDocument200Response();
        response.setId(document.getId());
        response.setTitle(document.getTitle());
        response.setCreated(String.valueOf(document.getAdded()));
        response.setModified(String.valueOf(document.getModified()));
        response.setAdded(String.valueOf(document.getAdded()));
        response.setContent(document.getContent());
        return new ResponseEntity<>(response, HttpStatus.OK);
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

            // send RabbitMQ the ID of file in MinIO Storage and database
            messageService.sendMessage(documentsDocumentDto.getId());

            // task_id has to be returned to the frontend, so set example task id
            // TODO: create new task (?)
            String response = "{\"task_id\": \"" + documentsDocumentDto.getId() + "\"}"; // needed for the progress bar to complete
            ApiUtil.setExampleResponse(request, "application/json", response);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (UploadFileException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<GetDocuments200Response> getDocuments(Integer page, Integer pageSize, String query, String ordering, List<Integer> tagsIdAll, Integer documentTypeId, Integer storagePathIdIn, Integer correspondentId, Boolean truncateContent, String title__icontains) {
        log.info("getDocuments Request: page=" + page + ", pageSize=" + pageSize + ", query=" + query + ", ordering=" + ordering + ", tagsIdAll=" + tagsIdAll + ", documentTypeId=" + documentTypeId + ", storagePathIdIn=" + storagePathIdIn + ", correspondentId=" + correspondentId + ", truncateContent=" + truncateContent + ", title__icontains=" + title__icontains);
        List<Document> documents = new ArrayList<>();
        page = page == null ? 1 : page;
        if(title__icontains != null) {
            documents = elasticSearchService.getDocumentByFieldName(title__icontains, "title");
        }
        else if (query != null) {
            documents = elasticSearchService.getDocumentByFieldName(query, "content");
        }
        else {
            documents = documentsDocumentService.getAllDocuments();
        }
        GetDocuments200Response response = new GetDocuments200Response();
        response.setCount(documents.size());
        response.setNext(page + 1);
        response.setPrevious(page - 1);
        response.setAll(List.of(page, page));
        List<GetDocuments200ResponseResultsInner> results = response.getResults();
        for (Document document : documents) {
            GetDocuments200ResponseResultsInner result = new GetDocuments200ResponseResultsInner();
            result.setId(document.getId());
            result.setTitle(document.getTitle().get());
            result.setCreated(String.valueOf(document.getAdded()));
            result.setModified(String.valueOf(document.getModified()));
            result.setAdded(String.valueOf(document.getAdded()));
            result.setContent(document.getContent().get());
            results.add(result);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> bulkEdit(
            @Parameter(name = "BulkEditRequest", description = "") @Valid @RequestBody(required = false) BulkEditRequest bulkEditRequest
    ) throws CouldNotDeleteFileException {
        log.info("bulkEdit Request: " + bulkEditRequest.toString());
        if(bulkEditRequest.getDocuments() != null && bulkEditRequest.getMethod().equals("delete")) {
            log.info("documents: " + bulkEditRequest.getDocuments().toString());
            for(Integer id : bulkEditRequest.getDocuments()) {
                elasticSearchService.deleteDocumentById(id);
                documentsDocumentService.deleteDocumentById(id);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // download a document
    @Override
    public ResponseEntity<Resource> downloadDocument(Integer id, Boolean original) {
        // get pdf file from miniostorage
        Resource file = documentsDocumentService.downloadFile(id);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UpdateDocument200Response> updateDocument(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "UpdateDocumentRequest", description = "") @Valid @RequestBody(required = false) UpdateDocumentRequest updateDocumentRequest
    ) {

        // DocumentsDocumentDto tempDocument = documentsDocumentService.getDocumentById(id);
        DocumentsDocument document = new DocumentsDocument();

        document.setId(id);

        // all @NotNull members of DocumentsDocumentDto
        document.setFilename(updateDocumentRequest.getOriginalFileName());
        document.setTitle(updateDocumentRequest.getTitle());
        document.setContent(updateDocumentRequest.getContent());
        document.setCreated(OffsetDateTime.parse(updateDocumentRequest.getCreatedDate()));
        document.setModified(OffsetDateTime.parse(updateDocumentRequest.getModified()));
        document.setChecksum("123456789");
        document.setAdded(OffsetDateTime.parse(updateDocumentRequest.getAdded()));
        document.setStorageType("local");
        document.setMimeType("application/pdf");

        DocumentsDocument saved = documentsDocumentService.updateDocument(document);

        log.info("Updated document id: " + saved.getId() + " and title " + saved.getTitle());

        return new ResponseEntity<>(HttpStatus.OK);

        // set id
//        document.setId(id);
//
//        // set correspondent
//        Integer correspondentValue = updateDocumentRequest.getCorrespondent();
//        JsonNullable<Integer> jsonNullableCorrespondent = JsonNullable.of(correspondentValue);
//        document.setCorrespondent(jsonNullableCorrespondent);
//
//        // set doctype
//        Integer docTypeValue = updateDocumentRequest.getDocumentType();
//        JsonNullable<Integer> jsonNullableDocType = JsonNullable.of(docTypeValue);
//        document.setDocumentType(jsonNullableDocType);
//
//        // path
//        Integer storagePathValue = updateDocumentRequest.getStoragePath();
//        JsonNullable<Integer> jsonNullableStoragePath = JsonNullable.of(storagePathValue);
//        document.setStoragePath(jsonNullableStoragePath);
//
//        // title
//        String titleValue = updateDocumentRequest.getTitle();
//        JsonNullable<String> jsonNullableTitleValue = JsonNullable.of(titleValue);
//        document.setTitle(jsonNullableTitleValue);
//
//        // content
//        String contentValue = updateDocumentRequest.getContent();
//        JsonNullable<String> jsonNullableContentValue = JsonNullable.of(contentValue);
//        document.setContent(jsonNullableContentValue);
//
//        // tags
//        List<Integer> tagsValue = updateDocumentRequest.getTags();
//        JsonNullable<List<Integer>> jsonNullableTagsValue = JsonNullable.of(tagsValue);
//        document.setTags(jsonNullableTagsValue);
//
//        // created date
//        OffsetDateTime createdDateValue = OffsetDateTime.parse(updateDocumentRequest.getCreatedDate());
//        document.setCreated(createdDateValue);
//
//        //  modified
//        OffsetDateTime modifiedValue = OffsetDateTime.parse(updateDocumentRequest.getModified());
//        document.setCreated(modifiedValue);
//
//        //  added
//        OffsetDateTime addedValue = OffsetDateTime.parse(updateDocumentRequest.getAdded());
//        document.setCreated(modifiedValue);
//
//        // archive serial nr
//        String archiveValue = String.valueOf(updateDocumentRequest.getArchiveSerialNumber());
//        JsonNullable<String> jsonNullableArchiveValue = JsonNullable.of(archiveValue);
//        document.setContent(jsonNullableArchiveValue);
//
//        // orig filename
//        String filenameValue = updateDocumentRequest.getOriginalFileName();
//        JsonNullable<String> jsonNullableFilenameValue = JsonNullable.of(filenameValue);
//        document.setContent(jsonNullableFilenameValue);
//
//        // archiv filename
//        String archiveFilenameValue = updateDocumentRequest.getArchivedFileName();
//        JsonNullable<String> jsonNullableArchiveFilenameValue = JsonNullable.of(archiveFilenameValue);
//        document.setContent(jsonNullableArchiveFilenameValue);
//

    }
}