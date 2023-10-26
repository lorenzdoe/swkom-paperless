package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "auth_permission", indexes = {
        @Index(name = "auth_permission_content_type_id_codename_01ab375a_uniq", columnList = "content_type, codename", unique = true),
        @Index(name = "auth_permission_content_type_id_2f476e4b", columnList = "content_type")
})
public class AuthPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 100)
    @NotNull
    @Column(name = "content_type", nullable = false, length = 100)
    private String contentType;

    @Size(max = 100)
    @NotNull
    @Column(name = "codename", nullable = false, length = 100)
    private String codename;

    @OneToMany(mappedBy = "permission")
    private Set<AuthGroupPermission> authGroupPermissions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "permission")
    private Set<AuthUserUserPermission> authUserUserPermissions = new LinkedHashSet<>();

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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public Set<AuthGroupPermission> getAuthGroupPermissions() {
        return authGroupPermissions;
    }

    public void setAuthGroupPermissions(Set<AuthGroupPermission> authGroupPermissions) {
        this.authGroupPermissions = authGroupPermissions;
    }

    public Set<AuthUserUserPermission> getAuthUserUserPermissions() {
        return authUserUserPermissions;
    }

    public void setAuthUserUserPermissions(Set<AuthUserUserPermission> authUserUserPermissions) {
        this.authUserUserPermissions = authUserUserPermissions;
    }

}