package at.fhtw.swkom.paperless.controller.document_types;

import at.fhtw.swkom.paperless.controller.document_types.DocumentTypes;
import at.fhtw.swkom.paperless.persistance.dtos.AuthUserDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumenttypeDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumenttype;
import at.fhtw.swkom.paperless.services.dto.*;
import at.fhtw.swkom.paperless.services.impl.DocumentsDocumenttypeService;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-18T10:19:48.387240Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class DocumentTypesController implements DocumentTypes {

    private final NativeWebRequest request;

    @Autowired
    public DocumentTypesController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Autowired
    private DocumentsDocumenttypeService documentsDocumenttypeService;

    @Override
    public ResponseEntity<CreateDocumentType200Response> createDocumentType(CreateCorrespondentRequest createCorrespondentRequest) {

        Integer ownerId = createCorrespondentRequest.getOwner();

        AuthUser owner = documentsDocumenttypeService.getAuthUserById(ownerId);

        DocumentsDocumenttype newDocumentType = documentsDocumenttypeService.createDocumentType(
                createCorrespondentRequest.getName(),
                createCorrespondentRequest.getMatch(),
                createCorrespondentRequest.getMatchingAlgorithm(),
                createCorrespondentRequest.getIsInsensitive(),
                owner
        );

        CreateDocumentType200Response response = new CreateDocumentType200Response();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<GetDocumentTypes200Response> getDocumentTypes(
//            @RequestParam(value = "page", required = false) Integer page,
//            @RequestParam(value = "full_perms", required = false) Boolean fullPerms
//    ) {
//        List<DocumentsDocumenttypeDto> documentTypes = documentsDocumenttypeService.getAllDocumentTypes();
//
//        GetDocumentTypes200Response response = new GetDocumentTypes200Response();
//        response.setCount(documentTypes.size());
//
//        List<GetDocumentTypes200ResponseResultsInner> results = documentTypes.stream()
//                .map(this::mapDocumentTypeDtoToResponseInner)
//                .collect(Collectors.toList());
//
//        response.setResults(results);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    private GetDocumentTypes200ResponseResultsInner mapDocumentTypeDtoToResponseInner(DocumentsDocumenttypeDto documentTypeDto) {
//        GetDocumentTypes200ResponseResultsInner responseInner = new GetDocumentTypes200ResponseResultsInner();
//        responseInner.setId(documentTypeDto.getId());
//        responseInner.setName(documentTypeDto.getName());
//        responseInner.setMatch(documentTypeDto.getMatch());
//        responseInner.setMatchingAlgorithm(documentTypeDto.getMatchingAlgorithm());
//        responseInner.setIsInsensitive(documentTypeDto.getIsInsensitive());
//        responseInner.setOwner(documentTypeDto.getOwner().getId());
//        responseInner.setPermissions(new GetCorrespondents200ResponseResultsInnerPermissions());
//        return responseInner;
//    }

}