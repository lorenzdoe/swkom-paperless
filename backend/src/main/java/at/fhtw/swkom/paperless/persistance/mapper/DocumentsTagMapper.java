package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsSavedviewDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsTagDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedview;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsTag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentsTagMapper {
    DocumentsTagMapper INSTANCE = Mappers.getMapper(DocumentsTagMapper.class);
    DocumentsTagDto convert(DocumentsTag documentsTag);
    DocumentsTag convert(DocumentsTagDto documentsTagDto);
}