package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "auth_group", indexes = {
        @Index(name = "auth_group_name_key", columnList = "name", unique = true),
        @Index(name = "auth_group_name_a6ea08ec_like", columnList = "name")
})
public class AuthGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 150)
    @NotNull
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @OneToMany(mappedBy = "group")
    private Set<AuthGroupPermission> authGroupPermissions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "group")
    private Set<AuthUserGroup> authUserGroups = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AuthGroupPermission> getAuthGroupPermissions() {
        return authGroupPermissions;
    }

    public void setAuthGroupPermissions(Set<AuthGroupPermission> authGroupPermissions) {
        this.authGroupPermissions = authGroupPermissions;
    }

    public Set<AuthUserGroup> getAuthUserGroups() {
        return authUserGroups;
    }

    public void setAuthUserGroups(Set<AuthUserGroup> authUserGroups) {
        this.authUserGroups = authUserGroups;
    }

}