package at.fhtw.swkom.paperless.persistance.mapper;

import at.fhtw.swkom.paperless.persistance.dtos.AuthUserUserPermissionDto;
import at.fhtw.swkom.paperless.persistance.dtos.DocumentsCorrespondentDto;
import at.fhtw.swkom.paperless.persistance.entities.AuthUserUserPermission;
import at.fhtw.swkom.paperless.persistance.entities.DocumentsCorrespondent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentsCorrespondentMapper {
    DocumentsCorrespondentMapper INSTANCE = Mappers.getMapper(DocumentsCorrespondentMapper.class);
    DocumentsCorrespondentDto convert(DocumentsCorrespondent documentsCorrespondent);
    DocumentsCorrespondent convert(DocumentsCorrespondentDto documentsCorrespondentDto);
}
