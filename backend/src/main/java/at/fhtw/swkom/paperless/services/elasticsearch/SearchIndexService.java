package at.fhtw.swkom.paperless.services.elasticsearch;

import at.fhtw.swkom.paperless.services.dto.Document;
import co.elastic.clients.elasticsearch._types.Result;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface SearchIndexService {
    Result indexDocument(Document document) throws IOException;

    Optional<Document> getDocumentById(int id);

//    List<Document> getDocumentByQuery(String query);

    boolean deleteDocumentById(int id);
}
