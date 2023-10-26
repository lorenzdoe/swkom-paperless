package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "documents_document_tags", indexes = {
        @Index(name = "documents_document_tags_document_id_tag_id_07e90502_uniq", columnList = "document_id, tag_id", unique = true),
        @Index(name = "documents_document_tags_document_id_006f35a8", columnList = "document_id"),
        @Index(name = "documents_document_tags_tag_id_4f4a71e9", columnList = "tag_id")
})
public class DocumentsDocumentTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "document_id", nullable = false)
    private DocumentsDocument document;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_id", nullable = false)
    private DocumentsTag tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocumentsDocument getDocument() {
        return document;
    }

    public void setDocument(DocumentsDocument document) {
        this.document = document;
    }

    public DocumentsTag getTag() {
        return tag;
    }

    public void setTag(DocumentsTag tag) {
        this.tag = tag;
    }

}