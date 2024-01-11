package at.fhtw.swkom.paperless.services.elasticsearch;

import at.fhtw.swkom.paperless.config.elasticsearch.ElasticSearchConfig;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.repositories.DocumentsRepository;
import at.fhtw.swkom.paperless.services.dto.Document;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Result;
import co.elastic.clients.elasticsearch._types.query_dsl.Operator;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ElasticSearchService implements SearchIndexService{

         DocumentsRepository documentsRepository;

    private final ElasticsearchClient esClient;

    @Autowired
    public ElasticSearchService(ElasticsearchClient esClient) throws IOException {
        this.esClient = esClient;

        if (!esClient.indices().exists(
                i -> i.index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME)
        ).value()) {
            esClient.indices().create(c -> c
                    .index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME)
            );
        }
    }

    @Override
    public Result indexDocument(Document document) throws IOException {
        IndexResponse response = esClient.index(i -> i
                .index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME)
                .id(document.getId().toString())
                .document(document)
        );
        String logMsg = "Indexed document " + document.getId() + ": result=" + response.result() + ", index=" + response.index();
        if ( response.result()!=Result.Created && response.result()!=Result.Updated )
            log.error("Failed to " + logMsg);
        else
            log.info(logMsg);
        return response.result();
    }

    @Override
    public Optional<Document> getDocumentById(int id) {
        try {
            GetResponse<Document> response = esClient.get(g -> g
                            .index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME)
                            .id(String.valueOf(id)),
                    Document.class
            );
            return (response.found() && response.source()!=null) ? Optional.of(response.source()) : Optional.empty();
        } catch (IOException e) {
            log.error("Failed to get document id=" + id + " from elasticsearch: " + e);
            return Optional.empty();
        }
    }

    public List<Document> getDocumentByFieldName(String searchText, String fieldName) {
        try {
            if (searchText == null || searchText.isEmpty()) {
                log.debug("No search text provided");
                return Collections.emptyList();
            }
            SearchResponse<Document> response = esClient.search(s -> s
                            .index("documents")
                            .query(q -> q
                                    .match(t -> t
                                            .field(fieldName)
                                            .query(searchText)
                                            .operator(Operator.And)
                                            .fuzziness(String.valueOf(10))
                                    )
                            ),
                    Document.class
            );

            TotalHits total = response.hits().total();
            boolean isExactResult = false;
            if (total != null) {
                isExactResult = total.relation() == TotalHitsRelation.Eq;
            }

            if (isExactResult) {
                log.info("There are " + total.value() + " results");
            } else {
                assert total != null;
                log.info("There are more than " + total.value() + " results");
            }

            List<Hit<Document>> hits = response.hits().hits();
            List<Document> returnDocuments = new ArrayList<>();
            for (Hit<Document> hit: hits) {
                Document document = hit.source();
                assert document != null;
                returnDocuments.add(document);
                log.info("Found product " + document.getTitle());
            }
            return returnDocuments;
        } catch (Exception e) {
            log.error("Failed to get document titled=" + searchText + " from elasticsearch: " + e);
        }
        return Collections.emptyList();
    }

    @Override
    public boolean deleteDocumentById(int id) {
        DeleteResponse result = null;
        try {
            result = esClient.delete(d -> d.index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME).id(String.valueOf(id)));
        } catch (IOException e) {
            log.warn("Failed to delete document id=" + id + " from elasticsearch: " + e);
        }
        if ( result==null )
            return false;
        if (result.result() != Result.Deleted )
            log.warn(result.toString());
        return result.result()==Result.Deleted;
    }

}