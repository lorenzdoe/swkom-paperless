package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailruleAssignTag}
 */
public class PaperlessMailMailruleAssignTagDto implements Serializable {
    private Integer id;
    @NotNull
    private PaperlessMailMailruleDto mailrule;
    @NotNull
    private DocumentsTagDto tag;

    public PaperlessMailMailruleAssignTagDto() {
    }

    public PaperlessMailMailruleAssignTagDto(Integer id, PaperlessMailMailruleDto mailrule, DocumentsTagDto tag) {
        this.id = id;
        this.mailrule = mailrule;
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public PaperlessMailMailruleAssignTagDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public PaperlessMailMailruleDto getMailrule() {
        return mailrule;
    }

    public PaperlessMailMailruleAssignTagDto setMailrule(PaperlessMailMailruleDto mailrule) {
        this.mailrule = mailrule;
        return this;
    }

    public DocumentsTagDto getTag() {
        return tag;
    }

    public PaperlessMailMailruleAssignTagDto setTag(DocumentsTagDto tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperlessMailMailruleAssignTagDto entity = (PaperlessMailMailruleAssignTagDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.mailrule, entity.mailrule) &&
                Objects.equals(this.tag, entity.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mailrule, tag);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "mailrule = " + mailrule + ", " +
                "tag = " + tag + ")";
    }
}