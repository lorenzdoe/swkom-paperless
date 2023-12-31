package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumentTag}
 */
@Getter
@Builder
public class DocumentsDocumentTagDto implements Serializable {
    private Integer id;
    @NotNull
    private DocumentsDocumentDto document;
    @NotNull
    private DocumentsTagDto tag;

    public DocumentsDocumentTagDto() {
    }

    public DocumentsDocumentTagDto(Integer id,
                                   DocumentsDocumentDto document,
                                   DocumentsTagDto tag) {
        this.id = id;
        this.document = document;
        this.tag = tag;
    }

    public DocumentsDocumentTagDto setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsDocumentTagDto entity = (DocumentsDocumentTagDto) o;
        return Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ")";
    }

    public DocumentsDocumentTagDto setDocument(DocumentsDocumentDto document) {
        this.document = document;
        return this;
    }

    public DocumentsDocumentTagDto setTag(DocumentsTagDto tag) {
        this.tag = tag;
        return this;
    }
}