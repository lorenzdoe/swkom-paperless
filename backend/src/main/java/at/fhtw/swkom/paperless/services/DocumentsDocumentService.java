package at.fhtw.swkom.paperless.services;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import at.fhtw.swkom.paperless.persistance.mapper.DocumentsDocumentMapper;
import at.fhtw.swkom.paperless.persistance.repositories.DocumentsDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentsDocumentService {
    @Autowired
    private DocumentsDocumentRepository documentsDocumentRepository;

    @Autowired
    private DocumentsDocumentMapper documentsDocumentMapper;

    public DocumentsDocument uploadFile(DocumentsDocumentDto documentsDocumentDto){
        System.out.println("preparing uploading file");
        DocumentsDocument document = documentsDocumentMapper.convert(documentsDocumentDto);
        //documentsDocumentRepository.update?
        return document;
    }

    public DocumentsDocumentService(){};

}
