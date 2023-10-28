package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthPermissionDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthtokenTokenDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthPermission;
import at.fhtw.swkom.paperless.persistance.entities.AuthtokenToken;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthtokenTokenMapper {
    AuthtokenTokenMapper INSTANCE = Mappers.getMapper(AuthtokenTokenMapper.class);
    AuthtokenTokenDto convert(AuthtokenToken authtokenToken);
    AuthtokenToken convert(AuthtokenTokenDto authtokenTokenDto);

}
