package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;

@Entity
@Table(name = "authtoken_token", indexes = {
        @Index(name = "authtoken_token_user_id_key", columnList = "user_id", unique = true)
})
public class AuthtokenToken {
    @Id
    @Size(max = 40)
    @Column(name = "key", nullable = false, length = 40)
    private String key;

    @NotNull
    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser user;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public AuthUser getUser() {
        return user;
    }

    public void setUser(AuthUser user) {
        this.user = user;
    }

}