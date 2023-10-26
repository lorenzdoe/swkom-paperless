package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

@Entity
@Table(name = "documents_note", indexes = {
        @Index(name = "documents_comment_created_dd512b3b", columnList = "created"),
        @Index(name = "documents_comment_document_id_3f5d21c7", columnList = "document_id"),
        @Index(name = "documents_comment_user_id_c281d4d5", columnList = "user_id")
})
public class DocumentsNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "note", nullable = false, length = Integer.MAX_VALUE)
    private String note;

    @NotNull
    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private DocumentsDocument document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AuthUser user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public DocumentsDocument getDocument() {
        return document;
    }

    public void setDocument(DocumentsDocument document) {
        this.document = document;
    }

    public AuthUser getUser() {
        return user;
    }

    public void setUser(AuthUser user) {
        this.user = user;
    }

}