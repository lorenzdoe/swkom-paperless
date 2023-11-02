package at.fhtw.swkom.paperless.services.impl;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumenttypeDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumenttype;
import at.fhtw.swkom.paperless.persistance.mapper.DocumentsDocumenttypeMapper;
import at.fhtw.swkom.paperless.persistance.repositories.AuthUserRepository;
import at.fhtw.swkom.paperless.persistance.repositories.DocumentsDocumenttypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentsDocumenttypeService {
    @Autowired
    private DocumentsDocumenttypeRepository documentsDocumenttypeRepository;

    @Autowired
    private DocumentsDocumenttypeMapper documentsDocumenttypeMapper;
    @Autowired
    private AuthUserRepository authUserRepository;

    public AuthUser getAuthUserById(Integer id) {
        return authUserRepository.findById(Long.valueOf(id)).orElse(null);
    }
    public DocumentsDocumenttype createDocumentType(
            String name,
            String match,
            Integer matchingAlgorithm,
            Boolean isInsensitive,
            AuthUser owner
    ) {
        DocumentsDocumenttype newDocumentType = new DocumentsDocumenttype();
        newDocumentType.setName(name);
        newDocumentType.setMatch(match);
        newDocumentType.setMatchingAlgorithm(matchingAlgorithm);
        newDocumentType.setIsInsensitive(isInsensitive);
        newDocumentType.setOwner(owner);

        return documentsDocumenttypeRepository.save(newDocumentType);
    }


    public List<DocumentsDocumenttypeDto> getAllDocumentTypes() {
        List<DocumentsDocumenttype> documentTypes = documentsDocumenttypeRepository.findAll();

        List<DocumentsDocumenttypeDto> documentTypeDtos = new ArrayList<>();

        documentTypes.forEach(documentType -> {
            DocumentsDocumenttypeDto documentTypeDto = documentsDocumenttypeMapper.convert(documentType);
            documentTypeDtos.add(documentTypeDto);
        });

        return documentTypeDtos;
    }
}
