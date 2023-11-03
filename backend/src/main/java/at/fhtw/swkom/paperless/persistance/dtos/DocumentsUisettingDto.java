package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsUisetting}
 */
@Builder
public class DocumentsUisettingDto implements Serializable {
    private Integer id;
    private Map<String, Object> settings;
    @NotNull
    private AuthUserDto user;

    public DocumentsUisettingDto() {
    }

    public DocumentsUisettingDto(Integer id, Map<String, Object> settings, AuthUserDto user) {
        this.id = id;
        this.settings = settings;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public DocumentsUisettingDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

    public DocumentsUisettingDto setSettings(Map<String, Object> settings) {
        this.settings = settings;
        return this;
    }

    public AuthUserDto getUser() {
        return user;
    }

    public DocumentsUisettingDto setUser(AuthUserDto user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsUisettingDto entity = (DocumentsUisettingDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.settings, entity.settings) &&
                Objects.equals(this.user, entity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, settings, user);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "settings = " + settings + ", " +
                "user = " + user + ")";
    }
}