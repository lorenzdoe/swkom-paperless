package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "documents_storagepath", indexes = {
        @Index(name = "documents_storagepath_unique_name_owner", columnList = "name, owner_id", unique = true),
        @Index(name = "documents_storagepath_name_uniq", columnList = "name", unique = true),
        @Index(name = "documents_storagepath_owner_id_c8f01fe8", columnList = "owner_id")
})
public class DocumentsStoragepath {
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

    @Size(max = 512)
    @NotNull
    @Column(name = "path", nullable = false, length = 512)
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @OneToMany(mappedBy = "storagePath")
    private Set<DocumentsDocument> documentsDocuments = new LinkedHashSet<>();

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

}