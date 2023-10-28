package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsSavedviewDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedview;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface DocumentsStoragepathMapper {
    DocumentsSavedviewMapper INSTANCE = Mappers.getMapper(DocumentsSavedviewMapper.class);
    DocumentsSavedviewDto convert(DocumentsSavedview documentsSavedview);
    DocumentsSavedview convert(DocumentsSavedviewDto documentsSavedviewDto);
}