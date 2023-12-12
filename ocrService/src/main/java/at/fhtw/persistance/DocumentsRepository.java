package at.fhtw.persistance;

import at.fhtw.services.dto.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsRepository extends ElasticsearchRepository<Document, String> {
    List<Document> findByNameContaining(String searchString);
}
