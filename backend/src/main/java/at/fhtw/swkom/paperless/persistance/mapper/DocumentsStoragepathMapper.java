package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsSavedviewDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsStoragepathDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedview;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsStoragepath;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface DocumentsStoragepathMapper {
    DocumentsStoragepathMapper INSTANCE = Mappers.getMapper(DocumentsStoragepathMapper.class);
    DocumentsStoragepathDto convert(DocumentsStoragepath documentsStoragepath);
    DocumentsStoragepath convert(DocumentsStoragepathDto documentsStoragepathDto);
}