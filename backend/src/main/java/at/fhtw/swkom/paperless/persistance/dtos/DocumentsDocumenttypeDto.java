package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumenttype}
 */
@Getter
@Builder
public class DocumentsDocumenttypeDto implements Serializable {
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
    private AuthUserDto owner;
    private Set<DocumentsDocumentDto> documentsDocuments = new LinkedHashSet<>();
    private Set<PaperlessMailMailruleDto> paperlessMailMailrules = new LinkedHashSet<>();

    public DocumentsDocumenttypeDto() {
    }

    public DocumentsDocumenttypeDto(Integer id, String name, String match, Integer matchingAlgorithm, Boolean isInsensitive, AuthUserDto owner, Set<DocumentsDocumentDto> documentsDocuments, Set<PaperlessMailMailruleDto> paperlessMailMailrules) {
        this.id = id;
        this.name = name;
        this.match = match;
        this.matchingAlgorithm = matchingAlgorithm;
        this.isInsensitive = isInsensitive;
        this.owner = owner;
        this.documentsDocuments = documentsDocuments;
        this.paperlessMailMailrules = paperlessMailMailrules;
    }

    public DocumentsDocumenttypeDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public DocumentsDocumenttypeDto setName(String name) {
        this.name = name;
        return this;
    }

    public DocumentsDocumenttypeDto setMatch(String match) {
        this.match = match;
        return this;
    }

    public DocumentsDocumenttypeDto setMatchingAlgorithm(Integer matchingAlgorithm) {
        this.matchingAlgorithm = matchingAlgorithm;
        return this;
    }

    public DocumentsDocumenttypeDto setIsInsensitive(Boolean isInsensitive) {
        this.isInsensitive = isInsensitive;
        return this;
    }

    public DocumentsDocumenttypeDto setOwner(AuthUserDto owner) {
        this.owner = owner;
        return this;
    }

    public DocumentsDocumenttypeDto setDocumentsDocuments(Set<DocumentsDocumentDto> documentsDocuments) {
        this.documentsDocuments = documentsDocuments;
        return this;
    }

    public DocumentsDocumenttypeDto setPaperlessMailMailrules(Set<PaperlessMailMailruleDto> paperlessMailMailrules) {
        this.paperlessMailMailrules = paperlessMailMailrules;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsDocumenttypeDto entity = (DocumentsDocumenttypeDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.match, entity.match) &&
                Objects.equals(this.matchingAlgorithm, entity.matchingAlgorithm) &&
                Objects.equals(this.isInsensitive, entity.isInsensitive) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.documentsDocuments, entity.documentsDocuments) &&
                Objects.equals(this.paperlessMailMailrules, entity.paperlessMailMailrules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, match, matchingAlgorithm, isInsensitive, owner, documentsDocuments, paperlessMailMailrules);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "match = " + match + ", " +
                "matchingAlgorithm = " + matchingAlgorithm + ", " +
                "isInsensitive = " + isInsensitive + ", " +
                "owner = " + owner + ", " +
                "documentsDocuments = " + documentsDocuments + ", " +
                "paperlessMailMailrules = " + paperlessMailMailrules + ")";
    }
}