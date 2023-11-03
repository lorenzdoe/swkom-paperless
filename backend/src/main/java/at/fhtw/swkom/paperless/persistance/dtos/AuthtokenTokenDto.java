package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.AuthtokenToken}
 */
@Builder
public class AuthtokenTokenDto implements Serializable {
    @Size(max = 40)
    private String key;
    @NotNull
    private OffsetDateTime created;
    @NotNull
    private AuthUserDto user;

    public AuthtokenTokenDto() {
    }

    public AuthtokenTokenDto(String key, OffsetDateTime created, AuthUserDto user) {
        this.key = key;
        this.created = created;
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public AuthtokenTokenDto setKey(String key) {
        this.key = key;
        return this;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public AuthtokenTokenDto setCreated(OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public AuthUserDto getUser() {
        return user;
    }

    public AuthtokenTokenDto setUser(AuthUserDto user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthtokenTokenDto entity = (AuthtokenTokenDto) o;
        return Objects.equals(this.key, entity.key) &&
                Objects.equals(this.created, entity.created) &&
                Objects.equals(this.user, entity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, created, user);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "key = " + key + ", " +
                "created = " + created + ", " +
                "user = " + user + ")";
    }
}