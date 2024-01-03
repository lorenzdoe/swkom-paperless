package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.services.dto.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DocumentsRepository extends ElasticsearchRepository<Document, String> {
    List<Document> findByTitleContaining(String searchString);

}
