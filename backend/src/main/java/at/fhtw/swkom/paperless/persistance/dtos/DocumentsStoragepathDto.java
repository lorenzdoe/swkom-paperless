package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsStoragepath}
 */
@Builder
public class DocumentsStoragepathDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 128)
    private String name;
    @NotNull
    @Size(max = 256)
    private String match;
    @NotNull
    private Integer matchingAlgorithm;
    @NotNull
    private Boolean isInsensitive = false;
    @NotNull
    @Size(max = 512)
    private String path;
    private AuthUserDto owner;
    private Set<DocumentsDocumentDto> documentsDocuments = new LinkedHashSet<>();

    public DocumentsStoragepathDto() {
    }

    public DocumentsStoragepathDto(Integer id, String name, String match, Integer matchingAlgorithm, Boolean isInsensitive, String path, AuthUserDto owner, Set<DocumentsDocumentDto> documentsDocuments) {
        this.id = id;
        this.name = name;
        this.match = match;
        this.matchingAlgorithm = matchingAlgorithm;
        this.isInsensitive = isInsensitive;
        this.path = path;
        this.owner = owner;
        this.documentsDocuments = documentsDocuments;
    }

    public Integer getId() {
        return id;
    }

    public DocumentsStoragepathDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DocumentsStoragepathDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getMatch() {
        return match;
    }

    public DocumentsStoragepathDto setMatch(String match) {
        this.match = match;
        return this;
    }

    public Integer getMatchingAlgorithm() {
        return matchingAlgorithm;
    }

    public DocumentsStoragepathDto setMatchingAlgorithm(Integer matchingAlgorithm) {
        this.matchingAlgorithm = matchingAlgorithm;
        return this;
    }

    public Boolean getIsInsensitive() {
        return isInsensitive;
    }

    public DocumentsStoragepathDto setIsInsensitive(Boolean isInsensitive) {
        this.isInsensitive = isInsensitive;
        return this;
    }

    public String getPath() {
        return path;
    }

    public DocumentsStoragepathDto setPath(String path) {
        this.path = path;
        return this;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    public DocumentsStoragepathDto setOwner(AuthUserDto owner) {
        this.owner = owner;
        return this;
    }

    public Set<DocumentsDocumentDto> getDocumentsDocuments() {
        return documentsDocuments;
    }

    public DocumentsStoragepathDto setDocumentsDocuments(Set<DocumentsDocumentDto> documentsDocuments) {
        this.documentsDocuments = documentsDocuments;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsStoragepathDto entity = (DocumentsStoragepathDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.match, entity.match) &&
                Objects.equals(this.matchingAlgorithm, entity.matchingAlgorithm) &&
                Objects.equals(this.isInsensitive, entity.isInsensitive) &&
                Objects.equals(this.path, entity.path) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.documentsDocuments, entity.documentsDocuments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, match, matchingAlgorithm, isInsensitive, path, owner, documentsDocuments);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "match = " + match + ", " +
                "matchingAlgorithm = " + matchingAlgorithm + ", " +
                "isInsensitive = " + isInsensitive + ", " +
                "path = " + path + ", " +
                "owner = " + owner + ", " +
                "documentsDocuments = " + documentsDocuments + ")";
    }
}