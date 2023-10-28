package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsSavedviewDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsSavedviewfilterruleDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedview;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedviewfilterrule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentsSavedviewfilterruleMapper {
    DocumentsSavedviewfilterruleMapper INSTANCE = Mappers.getMapper(DocumentsSavedviewfilterruleMapper.class);
    DocumentsSavedviewfilterruleDto convert(DocumentsSavedviewfilterrule documentsSavedviewfilterrule);
    DocumentsSavedviewfilterrule convert(DocumentsSavedviewfilterruleDto documentsSavedviewfilterruleDto);
}