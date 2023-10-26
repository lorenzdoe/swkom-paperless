package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "auth_user_user_permissions", indexes = {
        @Index(name = "auth_user_user_permissions_user_id_permission_id_14a6b632_uniq", columnList = "user_id, permission_id", unique = true),
        @Index(name = "auth_user_user_permissions_user_id_a95ead1b", columnList = "user_id"),
        @Index(name = "auth_user_user_permissions_permission_id_1fbb5f2c", columnList = "permission_id")
})
public class AuthUserUserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permission_id", nullable = false)
    private AuthPermission permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthUser getUser() {
        return user;
    }

    public void setUser(AuthUser user) {
        this.user = user;
    }

    public AuthPermission getPermission() {
        return permission;
    }

    public void setPermission(AuthPermission permission) {
        this.permission = permission;
    }

}