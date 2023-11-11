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
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.AuthPermission}
 */
@Getter
@Builder
public class AuthPermissionDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    @Size(max = 100)
    private String contentType;
    @NotNull
    @Size(max = 100)
    private String codename;
    private Set<AuthGroupPermissionDto> authGroupPermissions = new LinkedHashSet<>();
    private Set<AuthUserUserPermissionDto> authUserUserPermissions = new LinkedHashSet<>();

    public AuthPermissionDto() {
    }

    public AuthPermissionDto(Integer id, String name, String contentType, String codename, Set<AuthGroupPermissionDto> authGroupPermissions, Set<AuthUserUserPermissionDto> authUserUserPermissions) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
        this.codename = codename;
        this.authGroupPermissions = authGroupPermissions;
        this.authUserUserPermissions = authUserUserPermissions;
    }

    public AuthPermissionDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public AuthPermissionDto setName(String name) {
        this.name = name;
        return this;
    }

    public AuthPermissionDto setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public AuthPermissionDto setCodename(String codename) {
        this.codename = codename;
        return this;
    }

    public AuthPermissionDto setAuthGroupPermissions(Set<AuthGroupPermissionDto> authGroupPermissions) {
        this.authGroupPermissions = authGroupPermissions;
        return this;
    }

    public AuthPermissionDto setAuthUserUserPermissions(Set<AuthUserUserPermissionDto> authUserUserPermissions) {
        this.authUserUserPermissions = authUserUserPermissions;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthPermissionDto entity = (AuthPermissionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.contentType, entity.contentType) &&
                Objects.equals(this.codename, entity.codename) &&
                Objects.equals(this.authGroupPermissions, entity.authGroupPermissions) &&
                Objects.equals(this.authUserUserPermissions, entity.authUserUserPermissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contentType, codename, authGroupPermissions, authUserUserPermissions);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "contentType = " + contentType + ", " +
                "codename = " + codename + ", " +
                "authGroupPermissions = " + authGroupPermissions + ", " +
                "authUserUserPermissions = " + authUserUserPermissions + ")";
    }
}