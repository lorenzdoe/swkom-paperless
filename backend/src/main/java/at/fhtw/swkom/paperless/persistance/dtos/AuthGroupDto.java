package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.AuthGroup}
 */
@Getter
@Builder
public class AuthGroupDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 150)
    private String name;
    private Set<AuthGroupPermissionDto> authGroupPermissions = new LinkedHashSet<>();
    private Set<AuthUserGroupDto> authUserGroups = new LinkedHashSet<>();

    public AuthGroupDto() {
    }

    public AuthGroupDto(Integer id, String name, Set<AuthGroupPermissionDto> authGroupPermissions, Set<AuthUserGroupDto> authUserGroups) {
        this.id = id;
        this.name = name;
        this.authGroupPermissions = authGroupPermissions;
        this.authUserGroups = authUserGroups;
    }

    public AuthGroupDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public AuthGroupDto setName(String name) {
        this.name = name;
        return this;
    }

    public AuthGroupDto setAuthGroupPermissions(Set<AuthGroupPermissionDto> authGroupPermissions) {
        this.authGroupPermissions = authGroupPermissions;
        return this;
    }

    public AuthGroupDto setAuthUserGroups(Set<AuthUserGroupDto> authUserGroups) {
        this.authUserGroups = authUserGroups;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthGroupDto entity = (AuthGroupDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.authGroupPermissions, entity.authGroupPermissions) &&
                Objects.equals(this.authUserGroups, entity.authUserGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, authGroupPermissions, authUserGroups);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "authGroupPermissions = " + authGroupPermissions + ", " +
                "authUserGroups = " + authUserGroups + ")";
    }
}