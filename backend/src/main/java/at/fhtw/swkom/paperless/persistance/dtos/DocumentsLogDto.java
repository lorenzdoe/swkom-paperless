package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsLog}
 */
@Getter
@Builder
public class DocumentsLogDto implements Serializable {
    private Integer id;
    private UUID group;
    @NotNull
    private String message;
    @NotNull
    private Integer level;
    @NotNull
    private OffsetDateTime created;

    public DocumentsLogDto() {
    }

    public DocumentsLogDto(Integer id, UUID group, String message, Integer level, OffsetDateTime created) {
        this.id = id;
        this.group = group;
        this.message = message;
        this.level = level;
        this.created = created;
    }

    public DocumentsLogDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public DocumentsLogDto setGroup(UUID group) {
        this.group = group;
        return this;
    }

    public DocumentsLogDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public DocumentsLogDto setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public DocumentsLogDto setCreated(OffsetDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsLogDto entity = (DocumentsLogDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.group, entity.group) &&
                Objects.equals(this.message, entity.message) &&
                Objects.equals(this.level, entity.level) &&
                Objects.equals(this.created, entity.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, message, level, created);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "group = " + group + ", " +
                "message = " + message + ", " +
                "level = " + level + ", " +
                "created = " + created + ")";
    }
}