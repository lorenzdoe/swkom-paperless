package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupPermissionDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroupPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthGroupPermissionMapper {
    AuthGroupPermissionMapper INSTANCE = Mappers.getMapper(AuthGroupPermissionMapper.class);
    AuthGroupPermissionDto convert(AuthGroupPermission authGroupPermission);
}
