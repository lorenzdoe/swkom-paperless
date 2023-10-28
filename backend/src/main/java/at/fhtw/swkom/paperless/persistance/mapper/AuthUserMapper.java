package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthUserDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthUserMapper {
    AuthUserMapper INSTANCE = Mappers.getMapper(AuthUserMapper.class);
    AuthUserDto convert(AuthUser authUser);
    AuthUser convert(AuthUserDto authUserDto);

}
