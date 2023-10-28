package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsTagDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsUisettingDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsTag;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsUisetting;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentsUisettingMapper {
    DocumentsUisettingMapper INSTANCE = Mappers.getMapper(DocumentsUisettingMapper.class);
    DocumentsUisettingDto convert(DocumentsUisetting documentsUisetting);
    DocumentsUisetting convert(DocumentsUisettingDto documentsUisettingDto);
}