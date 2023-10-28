package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthUserDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthUserUserPermissionDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.AuthUserUserPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthUserUserPermissionMapper {
    AuthUserUserPermissionMapper INSTANCE = Mappers.getMapper(AuthUserUserPermissionMapper.class);
    AuthUserUserPermissionDto convert(AuthUserUserPermission authUserUserPermission);
    AuthUserUserPermission convert(AuthUserUserPermissionDto authUserUserPermissionDto);

}

