package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "documents_tag", indexes = {
        @Index(name = "documents_tag_unique_name_owner", columnList = "name, owner_id", unique = true),
        @Index(name = "documents_tag_name_uniq", columnList = "name", unique = true),
        @Index(name = "documents_tag_owner_id_f0875d77", columnList = "owner_id")
})
public class DocumentsTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 128)
    @NotNull
    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Size(max = 256)
    @NotNull
    @Column(name = "match", nullable = false, length = 256)
    private String match;

    @NotNull
    @Column(name = "matching_algorithm", nullable = false)
    private Integer matchingAlgorithm;

    @NotNull
    @Column(name = "is_insensitive", nullable = false)
    private Boolean isInsensitive = false;

    @NotNull
    @Column(name = "is_inbox_tag", nullable = false)
    private Boolean isInboxTag = false;

    @Size(max = 7)
    @NotNull
    @Column(name = "color", nullable = false, length = 7)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @OneToMany(mappedBy = "tag")
    private Set<DocumentsDocumentTag> documentsDocumentTags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tag")
    private Set<PaperlessMailMailruleAssignTag> paperlessMailMailruleAssignTags = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public Integer getMatchingAlgorithm() {
        return matchingAlgorithm;
    }

    public void setMatchingAlgorithm(Integer matchingAlgorithm) {
        this.matchingAlgorithm = matchingAlgorithm;
    }

    public Boolean getIsInsensitive() {
        return isInsensitive;
    }

    public void setIsInsensitive(Boolean isInsensitive) {
        this.isInsensitive = isInsensitive;
    }

    public Boolean getIsInboxTag() {
        return isInboxTag;
    }

    public void setIsInboxTag(Boolean isInboxTag) {
        this.isInboxTag = isInboxTag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

    public Set<DocumentsDocumentTag> getDocumentsDocumentTags() {
        return documentsDocumentTags;
    }

    public void setDocumentsDocumentTags(Set<DocumentsDocumentTag> documentsDocumentTags) {
        this.documentsDocumentTags = documentsDocumentTags;
    }

    public Set<PaperlessMailMailruleAssignTag> getPaperlessMailMailruleAssignTags() {
        return paperlessMailMailruleAssignTags;
    }

    public void setPaperlessMailMailruleAssignTags(Set<PaperlessMailMailruleAssignTag> paperlessMailMailruleAssignTags) {
        this.paperlessMailMailruleAssignTags = paperlessMailMailruleAssignTags;
    }

}