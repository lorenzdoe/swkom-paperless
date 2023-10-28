package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthGroupDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthGroupMapper {
    AuthGroupMapper INSTANCE = Mappers.getMapper(AuthGroupMapper.class);
    AuthGroupDto convert(AuthGroup authGroup);
}
