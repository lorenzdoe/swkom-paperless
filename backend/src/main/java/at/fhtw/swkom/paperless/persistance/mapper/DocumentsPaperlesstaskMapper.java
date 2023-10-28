package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsNoteDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsPaperlesstaskDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsNote;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsPaperlesstask;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentsPaperlesstaskMapper {
    DocumentsPaperlesstaskMapper INSTANCE = Mappers.getMapper(DocumentsPaperlesstaskMapper.class);
    DocumentsPaperlesstaskDto convert(DocumentsPaperlesstask documentsPaperlesstask);
    DocumentsPaperlesstask convert(DocumentsPaperlesstaskDto documentsPaperlesstaskDto);
}