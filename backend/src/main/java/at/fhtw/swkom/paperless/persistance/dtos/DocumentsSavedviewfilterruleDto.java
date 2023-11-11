package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedviewfilterrule}
 */
@Getter
@Builder
public class DocumentsSavedviewfilterruleDto implements Serializable {
    private Integer id;
    @NotNull
    private Integer ruleType;
    @Size(max = 255)
    private String value;
    @NotNull
    private DocumentsSavedviewDto savedView;

    public DocumentsSavedviewfilterruleDto() {
    }

    public DocumentsSavedviewfilterruleDto(Integer id, Integer ruleType, String value,
                                           DocumentsSavedviewDto savedView) {
        this.id = id;
        this.ruleType = ruleType;
        this.value = value;
        this.savedView = savedView;
    }

    public DocumentsSavedviewfilterruleDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public DocumentsSavedviewfilterruleDto setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
        return this;
    }

    public DocumentsSavedviewfilterruleDto setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsSavedviewfilterruleDto entity = (DocumentsSavedviewfilterruleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.ruleType, entity.ruleType) &&
                Objects.equals(this.value, entity.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ruleType, value);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "ruleType = " + ruleType + ", " +
                "value = " + value + ")";
    }

    public DocumentsSavedviewfilterruleDto setSavedView(DocumentsSavedviewDto savedView) {
        this.savedView = savedView;
        return this;
    }
}