package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailMailaccountDto;
import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailMailruleDto;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailaccount;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailrule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaperlessMailMailruleMapper {
    PaperlessMailMailruleMapper INSTANCE = Mappers.getMapper(PaperlessMailMailruleMapper.class);
    PaperlessMailMailruleDto convert(PaperlessMailMailrule paperlessMailMailrule);
    PaperlessMailMailrule convert(PaperlessMailMailruleDto paperlessMailMailruleDto);
}