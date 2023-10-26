package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsNote}
 */
public class DocumentsNoteDto implements Serializable {
    private Integer id;
    @NotNull
    private String note;
    @NotNull
    private OffsetDateTime created;
    private DocumentsDocumentDto document;
    private AuthUserDto user;

    public DocumentsNoteDto() {
    }

    public DocumentsNoteDto(Integer id, String note, OffsetDateTime created, DocumentsDocumentDto document, AuthUserDto user) {
        this.id = id;
        this.note = note;
        this.created = created;
        this.document = document;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public DocumentsNoteDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNote() {
        return note;
    }

    public DocumentsNoteDto setNote(String note) {
        this.note = note;
        return this;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public DocumentsNoteDto setCreated(OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public DocumentsDocumentDto getDocument() {
        return document;
    }

    public DocumentsNoteDto setDocument(DocumentsDocumentDto document) {
        this.document = document;
        return this;
    }

    public AuthUserDto getUser() {
        return user;
    }

    public DocumentsNoteDto setUser(AuthUserDto user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsNoteDto entity = (DocumentsNoteDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.note, entity.note) &&
                Objects.equals(this.created, entity.created) &&
                Objects.equals(this.document, entity.document) &&
                Objects.equals(this.user, entity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note, created, document, user);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "note = " + note + ", " +
                "created = " + created + ", " +
                "document = " + document + ", " +
                "user = " + user + ")";
    }
}