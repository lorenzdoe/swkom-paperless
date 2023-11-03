package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentTagDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumenttypeDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsTagDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumentTag;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumenttype;
import at.fhtw.swkom.paperless.services.dto.DocumentType;
import at.fhtw.swkom.paperless.services.dto.GetDocumentTypes200ResponseResultsInner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentsDocumenttypeMapper {
    DocumentsDocumenttypeMapper INSTANCE = Mappers.getMapper(DocumentsDocumenttypeMapper.class);
    DocumentsDocumenttypeDto convert(DocumentsDocumenttype documentsDocumenttype);
    DocumentsDocumenttype convert(DocumentsDocumenttypeDto documentsDocumenttypeDto);
}
