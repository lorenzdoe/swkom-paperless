package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.services.dto.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsRepository extends ElasticsearchRepository<Document, String> {
    List<Document> findByTitleContaining(String searchString);

}
