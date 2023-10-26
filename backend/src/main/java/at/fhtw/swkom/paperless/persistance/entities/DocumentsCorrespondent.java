package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "documents_correspondent", indexes = {
        @Index(name = "documents_correspondent_unique_name_owner", columnList = "name, owner_id", unique = true),
        @Index(name = "documents_correspondent_name_uniq", columnList = "name", unique = true),
        @Index(name = "documents_sender_name_18997c37_like", columnList = "name"),
        @Index(name = "documents_correspondent_owner_id_078f7f8a", columnList = "owner_id")
})
public class DocumentsCorrespondent {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @OneToMany(mappedBy = "correspondent")
    private Set<DocumentsDocument> documentsDocuments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "assignCorrespondent")
    private Set<PaperlessMailMailrule> paperlessMailMailrules = new LinkedHashSet<>();

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

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

    public Set<DocumentsDocument> getDocumentsDocuments() {
        return documentsDocuments;
    }

    public void setDocumentsDocuments(Set<DocumentsDocument> documentsDocuments) {
        this.documentsDocuments = documentsDocuments;
    }

    public Set<PaperlessMailMailrule> getPaperlessMailMailrules() {
        return paperlessMailMailrules;
    }

    public void setPaperlessMailMailrules(Set<PaperlessMailMailrule> paperlessMailMailrules) {
        this.paperlessMailMailrules = paperlessMailMailrules;
    }

}