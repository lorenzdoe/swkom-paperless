package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.AuthUserUserPermission}
 */
@Builder
public class AuthUserUserPermissionDto implements Serializable {
    private Integer id;
    @NotNull
    private AuthUserDto user;
    @NotNull
    private AuthPermissionDto permission;

    public AuthUserUserPermissionDto() {
    }

    public AuthUserUserPermissionDto(Integer id, AuthUserDto user, AuthPermissionDto permission) {
        this.id = id;
        this.user = user;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public AuthUserUserPermissionDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public AuthUserDto getUser() {
        return user;
    }

    public AuthUserUserPermissionDto setUser(AuthUserDto user) {
        this.user = user;
        return this;
    }

    public AuthPermissionDto getPermission() {
        return permission;
    }

    public AuthUserUserPermissionDto setPermission(AuthPermissionDto permission) {
        this.permission = permission;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUserUserPermissionDto entity = (AuthUserUserPermissionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.permission, entity.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, permission);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "user = " + user + ", " +
                "permission = " + permission + ")";
    }
}