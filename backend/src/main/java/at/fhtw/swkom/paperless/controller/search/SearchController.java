package at.fhtw.swkom.paperless.controller.search;

import at.fhtw.swkom.paperless.controller.ApiUtil;
import at.fhtw.swkom.paperless.controller.search.Search;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.elasticsearch.ElasticSearchService;
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

import java.util.List;
import java.util.Optional;

@Slf4j
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-18T10:19:48.387240Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class SearchController implements Search {

    private final NativeWebRequest request;

    @Autowired
    public SearchController(NativeWebRequest request) {
        this.request = request;
    }

    @Autowired
    ElasticSearchService elasticSearchService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<String>> autoComplete(String term, Integer limit) {
        List<Document> documents = elasticSearchService.search(term);

        for (Document document : documents) {
            log.info("Document Title: {}", document.getTitle());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
