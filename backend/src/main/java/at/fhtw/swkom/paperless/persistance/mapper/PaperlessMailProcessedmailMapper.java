package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailMailruleDto;
import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailProcessedmailDto;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailrule;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailProcessedmail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaperlessMailProcessedmailMapper {
    PaperlessMailProcessedmailMapper INSTANCE = Mappers.getMapper(PaperlessMailProcessedmailMapper.class);
    PaperlessMailProcessedmailDto convert(PaperlessMailProcessedmail paperlessMailProcessedmail);
    PaperlessMailProcessedmail convert(PaperlessMailProcessedmailDto paperlessMailProcessedmailDto);
}