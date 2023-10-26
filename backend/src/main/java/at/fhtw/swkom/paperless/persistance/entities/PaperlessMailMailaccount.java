package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "paperless_mail_mailaccount", indexes = {
        @Index(name = "paperless_mail_mailaccount_name_key", columnList = "name", unique = true),
        @Index(name = "paperless_mail_mailaccount_name_6af0ff82_like", columnList = "name"),
        @Index(name = "paperless_mail_mailaccount_owner_id_a894e5ee", columnList = "owner_id")
})
public class PaperlessMailMailaccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 256)
    @NotNull
    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Size(max = 256)
    @NotNull
    @Column(name = "imap_server", nullable = false, length = 256)
    private String imapServer;

    @Column(name = "imap_port")
    private Integer imapPort;

    @NotNull
    @Column(name = "imap_security", nullable = false)
    private Integer imapSecurity;

    @Size(max = 256)
    @NotNull
    @Column(name = "username", nullable = false, length = 256)
    private String username;

    @Size(max = 2048)
    @NotNull
    @Column(name = "password", nullable = false, length = 2048)
    private String password;

    @Size(max = 256)
    @NotNull
    @Column(name = "character_set", nullable = false, length = 256)
    private String characterSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @NotNull
    @Column(name = "is_token", nullable = false)
    private Boolean isToken = false;

    @OneToMany(mappedBy = "account")
    private Set<PaperlessMailMailrule> paperlessMailMailrules = new LinkedHashSet<>();

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

    public String getImapServer() {
        return imapServer;
    }

    public void setImapServer(String imapServer) {
        this.imapServer = imapServer;
    }

    public Integer getImapPort() {
        return imapPort;
    }

    public void setImapPort(Integer imapPort) {
        this.imapPort = imapPort;
    }

    public Integer getImapSecurity() {
        return imapSecurity;
    }

    public void setImapSecurity(Integer imapSecurity) {
        this.imapSecurity = imapSecurity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

    public Boolean getIsToken() {
        return isToken;
    }

    public void setIsToken(Boolean isToken) {
        this.isToken = isToken;
    }

    public Set<PaperlessMailMailrule> getPaperlessMailMailrules() {
        return paperlessMailMailrules;
    }

    public void setPaperlessMailMailrules(Set<PaperlessMailMailrule> paperlessMailMailrules) {
        this.paperlessMailMailrules = paperlessMailMailrules;
    }

}