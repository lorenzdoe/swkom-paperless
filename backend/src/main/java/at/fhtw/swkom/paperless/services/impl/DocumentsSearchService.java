//package at.fhtw.swkom.paperless.services.impl;
//
//import at.fhtw.swkom.paperless.persistance.repositories.DocumentsRepository;
//import at.fhtw.swkom.paperless.services.dto.Document;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DocumentsSearchService {
//    @Autowired
//    private DocumentsRepository documentsRepository;
//
//    public List<Document> search(String term) {
//        return documentsRepository.findByTitleContaining(term);
//    }
//}
