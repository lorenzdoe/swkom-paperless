package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentTagDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumentTag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentsDocumentTagMapper {
    DocumentsDocumentTagMapper INSTANCE = Mappers.getMapper(DocumentsDocumentTagMapper.class);
    DocumentsDocumentTagDto convert(DocumentsDocumentTag documentsDocumentTag);
    DocumentsDocumentTag convert(DocumentsDocumentTagDto documentsDocumentTagDto);
}