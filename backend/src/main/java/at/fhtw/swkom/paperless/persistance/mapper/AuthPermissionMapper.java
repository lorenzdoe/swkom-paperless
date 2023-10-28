package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthPermissionDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.entities.AuthPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthPermissionMapper {
    AuthtokenTokenMapper INSTANCE = Mappers.getMapper(AuthtokenTokenMapper.class);
    AuthPermissionDto convert(AuthPermission authPermission);
}
