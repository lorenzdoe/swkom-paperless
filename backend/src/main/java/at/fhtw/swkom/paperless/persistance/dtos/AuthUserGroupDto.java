package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.AuthUserGroup}
 */
@Builder
public class AuthUserGroupDto implements Serializable {
    private Integer id;
    @NotNull
    private AuthUserDto user;
    @NotNull
    private AuthGroupDto group;

    public AuthUserGroupDto() {
    }

    public AuthUserGroupDto(Integer id, AuthUserDto user, AuthGroupDto group) {
        this.id = id;
        this.user = user;
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public AuthUserGroupDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public AuthUserDto getUser() {
        return user;
    }

    public AuthUserGroupDto setUser(AuthUserDto user) {
        this.user = user;
        return this;
    }

    public AuthGroupDto getGroup() {
        return group;
    }

    public AuthUserGroupDto setGroup(AuthGroupDto group) {
        this.group = group;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUserGroupDto entity = (AuthUserGroupDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.group, entity.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, group);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "user = " + user + ", " +
                "group = " + group + ")";
    }
}