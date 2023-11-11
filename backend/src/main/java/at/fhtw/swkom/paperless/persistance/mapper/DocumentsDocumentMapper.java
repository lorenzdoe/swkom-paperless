package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentsDocumentMapper {
    DocumentsDocumentMapper INSTANCE = Mappers.getMapper(DocumentsDocumentMapper.class);
    DocumentsDocumentDto convert(DocumentsDocument documentsDocument);
    DocumentsDocument convert(DocumentsDocumentDto documentsDocumentDto);
}
