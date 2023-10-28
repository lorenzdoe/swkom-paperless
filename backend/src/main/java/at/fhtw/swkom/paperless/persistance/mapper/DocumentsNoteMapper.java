package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsLogDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsNoteDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsLog;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsNote;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentsNoteMapper {
    DocumentsNoteMapper INSTANCE = Mappers.getMapper(DocumentsNoteMapper.class);
    DocumentsNoteDto convert(DocumentsNote documentsNote);
    DocumentsNote convert(DocumentsNoteDto documentsNoteDto);
}
