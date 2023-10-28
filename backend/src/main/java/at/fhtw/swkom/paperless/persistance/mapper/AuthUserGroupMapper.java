package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthUserDto;
import at.fhtw.swkom.paperless.persistance.dtos.AuthUserGroupDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.AuthUserGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthUserGroupMapper {
    AuthUserGroupMapper INSTANCE = Mappers.getMapper(AuthUserGroupMapper.class);
    AuthUserGroupDto convert(AuthUserGroup authUserGroup);
    AuthUserGroup convert(AuthUserGroupDto authUserGroupDto);

}