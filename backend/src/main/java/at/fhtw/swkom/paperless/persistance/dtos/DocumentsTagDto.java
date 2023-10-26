package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsTag}
 */
public class DocumentsTagDto implements Serializable {
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
    private Boolean isInboxTag = false;
    @NotNull
    @Size(max = 7)
    private String color;
    private AuthUserDto owner;
    private Set<DocumentsDocumentTagDto> documentsDocumentTags = new LinkedHashSet<>();
    private Set<PaperlessMailMailruleAssignTagDto> paperlessMailMailruleAssignTags = new LinkedHashSet<>();

    public DocumentsTagDto() {
    }

    public DocumentsTagDto(Integer id, String name, String match, Integer matchingAlgorithm, Boolean isInsensitive, Boolean isInboxTag, String color, AuthUserDto owner, Set<DocumentsDocumentTagDto> documentsDocumentTags, Set<PaperlessMailMailruleAssignTagDto> paperlessMailMailruleAssignTags) {
        this.id = id;
        this.name = name;
        this.match = match;
        this.matchingAlgorithm = matchingAlgorithm;
        this.isInsensitive = isInsensitive;
        this.isInboxTag = isInboxTag;
        this.color = color;
        this.owner = owner;
        this.documentsDocumentTags = documentsDocumentTags;
        this.paperlessMailMailruleAssignTags = paperlessMailMailruleAssignTags;
    }

    public Integer getId() {
        return id;
    }

    public DocumentsTagDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DocumentsTagDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getMatch() {
        return match;
    }

    public DocumentsTagDto setMatch(String match) {
        this.match = match;
        return this;
    }

    public Integer getMatchingAlgorithm() {
        return matchingAlgorithm;
    }

    public DocumentsTagDto setMatchingAlgorithm(Integer matchingAlgorithm) {
        this.matchingAlgorithm = matchingAlgorithm;
        return this;
    }

    public Boolean getIsInsensitive() {
        return isInsensitive;
    }

    public DocumentsTagDto setIsInsensitive(Boolean isInsensitive) {
        this.isInsensitive = isInsensitive;
        return this;
    }

    public Boolean getIsInboxTag() {
        return isInboxTag;
    }

    public DocumentsTagDto setIsInboxTag(Boolean isInboxTag) {
        this.isInboxTag = isInboxTag;
        return this;
    }

    public String getColor() {
        return color;
    }

    public DocumentsTagDto setColor(String color) {
        this.color = color;
        return this;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    public DocumentsTagDto setOwner(AuthUserDto owner) {
        this.owner = owner;
        return this;
    }

    public Set<DocumentsDocumentTagDto> getDocumentsDocumentTags() {
        return documentsDocumentTags;
    }

    public DocumentsTagDto setDocumentsDocumentTags(Set<DocumentsDocumentTagDto> documentsDocumentTags) {
        this.documentsDocumentTags = documentsDocumentTags;
        return this;
    }

    public Set<PaperlessMailMailruleAssignTagDto> getPaperlessMailMailruleAssignTags() {
        return paperlessMailMailruleAssignTags;
    }

    public DocumentsTagDto setPaperlessMailMailruleAssignTags(Set<PaperlessMailMailruleAssignTagDto> paperlessMailMailruleAssignTags) {
        this.paperlessMailMailruleAssignTags = paperlessMailMailruleAssignTags;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsTagDto entity = (DocumentsTagDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.match, entity.match) &&
                Objects.equals(this.matchingAlgorithm, entity.matchingAlgorithm) &&
                Objects.equals(this.isInsensitive, entity.isInsensitive) &&
                Objects.equals(this.isInboxTag, entity.isInboxTag) &&
                Objects.equals(this.color, entity.color) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.documentsDocumentTags, entity.documentsDocumentTags) &&
                Objects.equals(this.paperlessMailMailruleAssignTags, entity.paperlessMailMailruleAssignTags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, match, matchingAlgorithm, isInsensitive, isInboxTag, color, owner, documentsDocumentTags, paperlessMailMailruleAssignTags);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "match = " + match + ", " +
                "matchingAlgorithm = " + matchingAlgorithm + ", " +
                "isInsensitive = " + isInsensitive + ", " +
                "isInboxTag = " + isInboxTag + ", " +
                "color = " + color + ", " +
                "owner = " + owner + ", " +
                "documentsDocumentTags = " + documentsDocumentTags + ", " +
                "paperlessMailMailruleAssignTags = " + paperlessMailMailruleAssignTags + ")";
    }
}