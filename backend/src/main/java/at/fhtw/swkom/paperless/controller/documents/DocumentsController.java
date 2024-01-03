package at.fhtw.swkom.paperless.controller.documents;

import at.fhtw.swkom.paperless.controller.ApiUtil;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.services.comm.MessageService;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.dto.GetDocuments200Response;
import at.fhtw.swkom.paperless.services.elasticsearch.ElasticSearchService;
import at.fhtw.swkom.paperless.services.exceptions.UploadFileException;
import at.fhtw.swkom.paperless.services.impl.DocumentsDocumentService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
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

    public ResponseEntity<GetDocuments200Response> getDocuments(Integer page, Integer pageSize, String query, String ordering, List<Integer> tagsIdAll, Integer documentTypeId, Integer storagePathIdIn, Integer correspondentId, Boolean truncateContent) {

        List<Document> documents = elasticSearchService.getDocumentByTitle(query);

        String exampleString = "{ \"next\" : 6, \"all\" : [ 5, 5 ], \"previous\" : 1, \"count\" : 0, \"results\" : [";
        for (Document document : documents) {
            exampleString +="{ \"owner\" : 4, \"user_can_change\" : true, \"archive_serial_number\" : 2, \"notes\" : [ { \"note\" : \"note\", \"created\" : \"created\", \"document\" : 1, \"id\" : " + document.getId() + ", \"user\" : 1 }, { \"note\" : \"note\", \"created\" : \"created\", \"document\" : 1, \"id\" : " + document.getId() + ", \"user\" : 1 } ], \"added\" : \"added\", \"created\" : \"created\", \"title\" : \"" + document.getTitle() + "\", \"content\" : \"" + document.getContent() + "\", \"tags\" : [ 3, 3 ], \"storage_path\" : 9, \"archived_file_name\" : \"archived_file_name\", \"modified\" : \"modified\", \"correspondent\" : 2, \"original_file_name\" : \"original_file_name\", \"id\" : 5, \"created_date\" : \"created_date\", \"document_type\" : 7 }, { \"owner\" : 4, \"user_can_change\" : true, \"archive_serial_number\" : 2, \"notes\" : [ { \"note\" : \"note\", \"created\" : \"created\", \"document\" : 1, \"id\" : 7, \"user\" : 1 }, { \"note\" : \"note\", \"created\" : \"created\", \"document\" : 1, \"id\" : 7, \"user\" : 1 } ], \"added\" : \"added\", \"created\" : \"created\", \"title\" : \"" + document.getTitle() + "\", \"content\" :  \"" + document.getContent() + " \", \"tags\" : [ 3, 3 ], \"storage_path\" : 9, \"archived_file_name\" : \"archived_file_name\", \"modified\" : \"modified\", \"correspondent\" : 2, \"original_file_name\" : \"original_file_name\", \"id\" : 5, \"created_date\" : \"created_date\", \"document_type\" : 7 }";
        }

        exampleString += "] }";
        ApiUtil.setExampleResponse(request, "application/json", exampleString);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}