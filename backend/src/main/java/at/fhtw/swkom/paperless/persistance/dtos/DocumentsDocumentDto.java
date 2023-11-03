package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument}
 */
@Builder
public class DocumentsDocumentDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 128)
    private String title;
    @NotNull
    private String content;
    @NotNull
    private OffsetDateTime created;
    @NotNull
    private OffsetDateTime modified;
    private DocumentsCorrespondentDto correspondent;
    @NotNull
    @Size(max = 32)
    private String checksum;
    @NotNull
    private OffsetDateTime added;
    @NotNull
    @Size(max = 11)
    private String storageType;
    @Size(max = 1024)
    private String filename;
    private Integer archiveSerialNumber;
    private DocumentsDocumenttypeDto documentType;
    @NotNull
    @Size(max = 256)
    private String mimeType;
    @Size(max = 32)
    private String archiveChecksum;
    @Size(max = 1024)
    private String archiveFilename;
    private DocumentsStoragepathDto storagePath;
    @Size(max = 1024)
    private String originalFilename;
    private AuthUserDto owner;
    private Set<DocumentsDocumentTagDto> documentsDocumentTags = new LinkedHashSet<>();
    private Set<DocumentsNoteDto> documentsNotes = new LinkedHashSet<>();

    public DocumentsDocumentDto() {
    }

    public DocumentsDocumentDto(Integer id, String title, String content, OffsetDateTime created, OffsetDateTime modified, DocumentsCorrespondentDto correspondent, String checksum, OffsetDateTime added, String storageType, String filename, Integer archiveSerialNumber, DocumentsDocumenttypeDto documentType, String mimeType, String archiveChecksum, String archiveFilename, DocumentsStoragepathDto storagePath, String originalFilename, AuthUserDto owner, Set<DocumentsDocumentTagDto> documentsDocumentTags, Set<DocumentsNoteDto> documentsNotes) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
        this.modified = modified;
        this.correspondent = correspondent;
        this.checksum = checksum;
        this.added = added;
        this.storageType = storageType;
        this.filename = filename;
        this.archiveSerialNumber = archiveSerialNumber;
        this.documentType = documentType;
        this.mimeType = mimeType;
        this.archiveChecksum = archiveChecksum;
        this.archiveFilename = archiveFilename;
        this.storagePath = storagePath;
        this.originalFilename = originalFilename;
        this.owner = owner;
        this.documentsDocumentTags = documentsDocumentTags;
        this.documentsNotes = documentsNotes;
    }

    public Integer getId() {
        return id;
    }

    public DocumentsDocumentDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DocumentsDocumentDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public DocumentsDocumentDto setContent(String content) {
        this.content = content;
        return this;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public DocumentsDocumentDto setCreated(OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public DocumentsDocumentDto setModified(OffsetDateTime modified) {
        this.modified = modified;
        return this;
    }

    public DocumentsCorrespondentDto getCorrespondent() {
        return correspondent;
    }

    public DocumentsDocumentDto setCorrespondent(DocumentsCorrespondentDto correspondent) {
        this.correspondent = correspondent;
        return this;
    }

    public String getChecksum() {
        return checksum;
    }

    public DocumentsDocumentDto setChecksum(String checksum) {
        this.checksum = checksum;
        return this;
    }

    public OffsetDateTime getAdded() {
        return added;
    }

    public DocumentsDocumentDto setAdded(OffsetDateTime added) {
        this.added = added;
        return this;
    }

    public String getStorageType() {
        return storageType;
    }

    public DocumentsDocumentDto setStorageType(String storageType) {
        this.storageType = storageType;
        return this;
    }

    public String getFilename() {
        return filename;
    }

    public DocumentsDocumentDto setFilename(String filename) {
        this.filename = filename;
        return this;
    }

    public Integer getArchiveSerialNumber() {
        return archiveSerialNumber;
    }

    public DocumentsDocumentDto setArchiveSerialNumber(Integer archiveSerialNumber) {
        this.archiveSerialNumber = archiveSerialNumber;
        return this;
    }

    public DocumentsDocumenttypeDto getDocumentType() {
        return documentType;
    }

    public DocumentsDocumentDto setDocumentType(DocumentsDocumenttypeDto documentType) {
        this.documentType = documentType;
        return this;
    }

    public String getMimeType() {
        return mimeType;
    }

    public DocumentsDocumentDto setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public String getArchiveChecksum() {
        return archiveChecksum;
    }

    public DocumentsDocumentDto setArchiveChecksum(String archiveChecksum) {
        this.archiveChecksum = archiveChecksum;
        return this;
    }

    public String getArchiveFilename() {
        return archiveFilename;
    }

    public DocumentsDocumentDto setArchiveFilename(String archiveFilename) {
        this.archiveFilename = archiveFilename;
        return this;
    }

    public DocumentsStoragepathDto getStoragePath() {
        return storagePath;
    }

    public DocumentsDocumentDto setStoragePath(DocumentsStoragepathDto storagePath) {
        this.storagePath = storagePath;
        return this;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public DocumentsDocumentDto setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
        return this;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    public DocumentsDocumentDto setOwner(AuthUserDto owner) {
        this.owner = owner;
        return this;
    }

    public Set<DocumentsDocumentTagDto> getDocumentsDocumentTags() {
        return documentsDocumentTags;
    }

    public DocumentsDocumentDto setDocumentsDocumentTags(Set<DocumentsDocumentTagDto> documentsDocumentTags) {
        this.documentsDocumentTags = documentsDocumentTags;
        return this;
    }

    public Set<DocumentsNoteDto> getDocumentsNotes() {
        return documentsNotes;
    }

    public DocumentsDocumentDto setDocumentsNotes(Set<DocumentsNoteDto> documentsNotes) {
        this.documentsNotes = documentsNotes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsDocumentDto entity = (DocumentsDocumentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.content, entity.content) &&
                Objects.equals(this.created, entity.created) &&
                Objects.equals(this.modified, entity.modified) &&
                Objects.equals(this.correspondent, entity.correspondent) &&
                Objects.equals(this.checksum, entity.checksum) &&
                Objects.equals(this.added, entity.added) &&
                Objects.equals(this.storageType, entity.storageType) &&
                Objects.equals(this.filename, entity.filename) &&
                Objects.equals(this.archiveSerialNumber, entity.archiveSerialNumber) &&
                Objects.equals(this.documentType, entity.documentType) &&
                Objects.equals(this.mimeType, entity.mimeType) &&
                Objects.equals(this.archiveChecksum, entity.archiveChecksum) &&
                Objects.equals(this.archiveFilename, entity.archiveFilename) &&
                Objects.equals(this.storagePath, entity.storagePath) &&
                Objects.equals(this.originalFilename, entity.originalFilename) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.documentsDocumentTags, entity.documentsDocumentTags) &&
                Objects.equals(this.documentsNotes, entity.documentsNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, created, modified, correspondent, checksum, added, storageType, filename, archiveSerialNumber, documentType, mimeType, archiveChecksum, archiveFilename, storagePath, originalFilename, owner, documentsDocumentTags, documentsNotes);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "content = " + content + ", " +
                "created = " + created + ", " +
                "modified = " + modified + ", " +
                "correspondent = " + correspondent + ", " +
                "checksum = " + checksum + ", " +
                "added = " + added + ", " +
                "storageType = " + storageType + ", " +
                "filename = " + filename + ", " +
                "archiveSerialNumber = " + archiveSerialNumber + ", " +
                "documentType = " + documentType + ", " +
                "mimeType = " + mimeType + ", " +
                "archiveChecksum = " + archiveChecksum + ", " +
                "archiveFilename = " + archiveFilename + ", " +
                "storagePath = " + storagePath + ", " +
                "originalFilename = " + originalFilename + ", " +
                "owner = " + owner + ", " +
                "documentsDocumentTags = " + documentsDocumentTags + ", " +
                "documentsNotes = " + documentsNotes + ")";
    }
}