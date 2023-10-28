package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailMailruleAssignTagDto;
import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailMailruleDto;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailrule;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailruleAssignTag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PaperlessMailMailruleAssignTagMapper {
    PaperlessMailMailruleAssignTagMapper INSTANCE = Mappers.getMapper(PaperlessMailMailruleAssignTagMapper.class);
    PaperlessMailMailruleAssignTagDto convert(PaperlessMailMailruleAssignTag paperlessMailMailruleAssignTag);
    PaperlessMailMailruleAssignTag convert(PaperlessMailMailruleAssignTagDto paperlessMailMailruleAssignTagDto);
}