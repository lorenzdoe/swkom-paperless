package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.AuthGroupPermission}
 */
@Builder
public class AuthGroupPermissionDto implements Serializable {
    private Integer id;
    @NotNull
    private AuthGroupDto group;
    @NotNull
    private AuthPermissionDto permission;

    public AuthGroupPermissionDto() {
    }

    public AuthGroupPermissionDto(Integer id, AuthGroupDto group, AuthPermissionDto permission) {
        this.id = id;
        this.group = group;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public AuthGroupPermissionDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public AuthGroupDto getGroup() {
        return group;
    }

    public AuthGroupPermissionDto setGroup(AuthGroupDto group) {
        this.group = group;
        return this;
    }

    public AuthPermissionDto getPermission() {
        return permission;
    }

    public AuthGroupPermissionDto setPermission(AuthPermissionDto permission) {
        this.permission = permission;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthGroupPermissionDto entity = (AuthGroupPermissionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.group, entity.group) &&
                Objects.equals(this.permission, entity.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, permission);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "group = " + group + ", " +
                "permission = " + permission + ")";
    }
}