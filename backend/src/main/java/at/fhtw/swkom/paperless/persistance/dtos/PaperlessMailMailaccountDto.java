package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailaccount}
 */
@Builder
public class PaperlessMailMailaccountDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 256)
    private String name;
    @NotNull
    @Size(max = 256)
    private String imapServer;
    private Integer imapPort;
    @NotNull
    private Integer imapSecurity;
    @NotNull
    @Size(max = 256)
    private String username;
    @NotNull
    @Size(max = 2048)
    private String password;
    @NotNull
    @Size(max = 256)
    private String characterSet;
    private AuthUserDto owner;
    @NotNull
    private Boolean isToken = false;
    private Set<PaperlessMailMailruleDto> paperlessMailMailrules = new LinkedHashSet<>();

    public PaperlessMailMailaccountDto() {
    }

    public PaperlessMailMailaccountDto(Integer id, String name, String imapServer, Integer imapPort, Integer imapSecurity, String username, String password, String characterSet, AuthUserDto owner, Boolean isToken, Set<PaperlessMailMailruleDto> paperlessMailMailrules) {
        this.id = id;
        this.name = name;
        this.imapServer = imapServer;
        this.imapPort = imapPort;
        this.imapSecurity = imapSecurity;
        this.username = username;
        this.password = password;
        this.characterSet = characterSet;
        this.owner = owner;
        this.isToken = isToken;
        this.paperlessMailMailrules = paperlessMailMailrules;
    }

    public Integer getId() {
        return id;
    }

    public PaperlessMailMailaccountDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PaperlessMailMailaccountDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getImapServer() {
        return imapServer;
    }

    public PaperlessMailMailaccountDto setImapServer(String imapServer) {
        this.imapServer = imapServer;
        return this;
    }

    public Integer getImapPort() {
        return imapPort;
    }

    public PaperlessMailMailaccountDto setImapPort(Integer imapPort) {
        this.imapPort = imapPort;
        return this;
    }

    public Integer getImapSecurity() {
        return imapSecurity;
    }

    public PaperlessMailMailaccountDto setImapSecurity(Integer imapSecurity) {
        this.imapSecurity = imapSecurity;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public PaperlessMailMailaccountDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PaperlessMailMailaccountDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public PaperlessMailMailaccountDto setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
        return this;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    public PaperlessMailMailaccountDto setOwner(AuthUserDto owner) {
        this.owner = owner;
        return this;
    }

    public Boolean getIsToken() {
        return isToken;
    }

    public PaperlessMailMailaccountDto setIsToken(Boolean isToken) {
        this.isToken = isToken;
        return this;
    }

    public Set<PaperlessMailMailruleDto> getPaperlessMailMailrules() {
        return paperlessMailMailrules;
    }

    public PaperlessMailMailaccountDto setPaperlessMailMailrules(Set<PaperlessMailMailruleDto> paperlessMailMailrules) {
        this.paperlessMailMailrules = paperlessMailMailrules;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperlessMailMailaccountDto entity = (PaperlessMailMailaccountDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.imapServer, entity.imapServer) &&
                Objects.equals(this.imapPort, entity.imapPort) &&
                Objects.equals(this.imapSecurity, entity.imapSecurity) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.characterSet, entity.characterSet) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.isToken, entity.isToken) &&
                Objects.equals(this.paperlessMailMailrules, entity.paperlessMailMailrules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imapServer, imapPort, imapSecurity, username, password, characterSet, owner, isToken, paperlessMailMailrules);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "imapServer = " + imapServer + ", " +
                "imapPort = " + imapPort + ", " +
                "imapSecurity = " + imapSecurity + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "characterSet = " + characterSet + ", " +
                "owner = " + owner + ", " +
                "isToken = " + isToken + ", " +
                "paperlessMailMailrules = " + paperlessMailMailrules + ")";
    }
}