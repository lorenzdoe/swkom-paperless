package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.DocumentsUisettingDto;
import at.fhtw.swkom.paperless.persistance.dtos.PaperlessMailMailaccountDto;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsUisetting;
import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailaccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PaperlessMailMailaccountMapper {
    PaperlessMailMailaccountMapper INSTANCE = Mappers.getMapper(PaperlessMailMailaccountMapper.class);
    PaperlessMailMailaccountDto convert(PaperlessMailMailaccount paperlessMailMailaccount);
    PaperlessMailMailaccount convert(PaperlessMailMailaccountDto paperlessMailMailaccountDto);
}