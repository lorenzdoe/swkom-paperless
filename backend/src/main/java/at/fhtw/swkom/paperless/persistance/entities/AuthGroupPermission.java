package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "auth_group_permissions", indexes = {
        @Index(name = "auth_group_permissions_group_id_permission_id_0cd325b0_uniq", columnList = "group_id, permission_id", unique = true),
        @Index(name = "auth_group_permissions_group_id_b120cbf9", columnList = "group_id"),
        @Index(name = "auth_group_permissions_permission_id_84c5c92e", columnList = "permission_id")
})
public class AuthGroupPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private AuthGroup group;

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

    public AuthGroup getGroup() {
        return group;
    }

    public void setGroup(AuthGroup group) {
        this.group = group;
    }

    public AuthPermission getPermission() {
        return permission;
    }

    public void setPermission(AuthPermission permission) {
        this.permission = permission;
    }

}