package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "auth_user_groups", indexes = {
        @Index(name = "auth_user_groups_user_id_group_id_94350c0c_uniq", columnList = "user_id, group_id", unique = true),
        @Index(name = "auth_user_groups_user_id_6a12ed8b", columnList = "user_id"),
        @Index(name = "auth_user_groups_group_id_97559544", columnList = "group_id")
})
public class AuthUserGroup {
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
    @JoinColumn(name = "group_id", nullable = false)
    private AuthGroup group;

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

    public AuthGroup getGroup() {
        return group;
    }

    public void setGroup(AuthGroup group) {
        this.group = group;
    }

}