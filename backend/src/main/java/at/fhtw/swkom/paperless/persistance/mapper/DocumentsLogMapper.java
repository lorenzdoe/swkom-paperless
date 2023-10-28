package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumenttypeDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsLogDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumenttype;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentsLogMapper {
    DocumentsLogMapper INSTANCE = Mappers.getMapper(DocumentsLogMapper.class);
    DocumentsLogDto convert(DocumentsLog documentsLog);
    DocumentsLog convert(DocumentsLogDto documentsLogDto);
}
