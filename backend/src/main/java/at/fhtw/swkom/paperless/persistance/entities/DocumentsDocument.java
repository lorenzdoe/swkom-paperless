package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "documents_document", indexes = {
        @Index(name = "documents_document_checksum_75209391_uniq", columnList = "checksum", unique = true),
        @Index(name = "documents_document_filename_3ee5ad97_uniq", columnList = "filename", unique = true),
        @Index(name = "documents_document_archive_serial_number_key", columnList = "archive_serial_number", unique = true),
        @Index(name = "documents_document_archive_filename_key", columnList = "archive_filename", unique = true),
        @Index(name = "documents_document_title_6b08e02a", columnList = "title"),
        @Index(name = "documents_document_title_6b08e02a_like", columnList = "title"),
        @Index(name = "documents_document_created_bedd0818", columnList = "created"),
        @Index(name = "documents_document_modified_2eae15bc", columnList = "modified"),
        @Index(name = "documents_document_sender_id_950512b2", columnList = "correspondent_id"),
        @Index(name = "documents_document_checksum_75209391_like", columnList = "checksum"),
        @Index(name = "documents_document_added_28cfa360", columnList = "added"),
        @Index(name = "documents_document_filename_3ee5ad97_like", columnList = "filename"),
        @Index(name = "documents_document_document_type_id_1f88b50c", columnList = "document_type_id"),
        @Index(name = "documents_document_archive_filename_fc3cb023_like", columnList = "archive_filename"),
        @Index(name = "documents_document_storage_path_id_07d27bdb", columnList = "storage_path_id"),
        @Index(name = "documents_document_owner_id_04d2b723", columnList = "owner_id")
})
public class DocumentsDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 128)
    @NotNull
    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @NotNull
    @Column(name = "content", nullable = false, length = Integer.MAX_VALUE)
    private String content;

    @NotNull
    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    @NotNull
    @Column(name = "modified", nullable = false)
    private OffsetDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "correspondent_id")
    private DocumentsCorrespondent correspondent;

    @Size(max = 32)
    @NotNull
    @Column(name = "checksum", nullable = false, length = 32)
    private String checksum;

    @NotNull
    @Column(name = "added", nullable = false)
    private OffsetDateTime added;

    @Size(max = 11)
    @NotNull
    @Column(name = "storage_type", nullable = false, length = 11)
    private String storageType;

    @Size(max = 1024)
    @Column(name = "filename", length = 1024)
    private String filename;

    @Column(name = "archive_serial_number")
    private Integer archiveSerialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id")
    private DocumentsDocumenttype documentType;

    @Size(max = 256)
    @NotNull
    @Column(name = "mime_type", nullable = false, length = 256)
    private String mimeType;

    @Size(max = 32)
    @Column(name = "archive_checksum", length = 32)
    private String archiveChecksum;

    @Size(max = 1024)
    @Column(name = "archive_filename", length = 1024)
    private String archiveFilename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_path_id")
    private DocumentsStoragepath storagePath;

    @Size(max = 1024)
    @Column(name = "original_filename", length = 1024)
    private String originalFilename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @OneToMany(mappedBy = "document")
    private Set<DocumentsDocumentTag> documentsDocumentTags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "document")
    private Set<DocumentsNote> documentsNotes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(OffsetDateTime modified) {
        this.modified = modified;
    }

    public DocumentsCorrespondent getCorrespondent() {
        return correspondent;
    }

    public void setCorrespondent(DocumentsCorrespondent correspondent) {
        this.correspondent = correspondent;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public OffsetDateTime getAdded() {
        return added;
    }

    public void setAdded(OffsetDateTime added) {
        this.added = added;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getArchiveSerialNumber() {
        return archiveSerialNumber;
    }

    public void setArchiveSerialNumber(Integer archiveSerialNumber) {
        this.archiveSerialNumber = archiveSerialNumber;
    }

    public DocumentsDocumenttype getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentsDocumenttype documentType) {
        this.documentType = documentType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getArchiveChecksum() {
        return archiveChecksum;
    }

    public void setArchiveChecksum(String archiveChecksum) {
        this.archiveChecksum = archiveChecksum;
    }

    public String getArchiveFilename() {
        return archiveFilename;
    }

    public void setArchiveFilename(String archiveFilename) {
        this.archiveFilename = archiveFilename;
    }

    public DocumentsStoragepath getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(DocumentsStoragepath storagePath) {
        this.storagePath = storagePath;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
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

    public Set<DocumentsNote> getDocumentsNotes() {
        return documentsNotes;
    }

    public void setDocumentsNotes(Set<DocumentsNote> documentsNotes) {
        this.documentsNotes = documentsNotes;
    }

}