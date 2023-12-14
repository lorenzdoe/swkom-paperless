package at.fhtw.services.elasticsearch;

import at.fhtw.config.elasticsearch.ElasticSearchConfig;
import at.fhtw.persistance.DocumentsRepository;
import at.fhtw.services.dto.Document;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Result;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ElasticSearchService {
    DocumentsRepository documentsRepository;

    @Autowired
    public ElasticSearchService(@Autowired DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    public void saveToElasticsearch(Document document) {
        log.info("savetoelasticsearch " + document.toString());
        documentsRepository.save(document);
    }
    public List<Document> search(String query) {
        return documentsRepository.findByTitleContaining(query);
    }
}
