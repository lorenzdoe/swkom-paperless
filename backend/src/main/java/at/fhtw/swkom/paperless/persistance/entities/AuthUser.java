package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "auth_user", indexes = {
        @Index(name = "auth_user_username_key", columnList = "username", unique = true),
        @Index(name = "auth_user_username_6821ab7c_like", columnList = "username")
})
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 128)
    @NotNull
    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "last_login")
    private OffsetDateTime lastLogin;

    @NotNull
    @Column(name = "is_superuser", nullable = false)
    private Boolean isSuperuser = false;

    @Size(max = 150)
    @NotNull
    @Column(name = "username", nullable = false, length = 150)
    private String username;

    @Size(max = 150)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 150)
    private String firstName;

    @Size(max = 150)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 150)
    private String lastName;

    @Size(max = 254)
    @NotNull
    @Column(name = "email", nullable = false, length = 254)
    private String email;

    @NotNull
    @Column(name = "is_staff", nullable = false)
    private Boolean isStaff = false;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @NotNull
    @Column(name = "date_joined", nullable = false)
    private OffsetDateTime dateJoined;

    @OneToMany(mappedBy = "user")
    private Set<AuthUserGroup> authUserGroups = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<AuthUserUserPermission> authUserUserPermissions = new LinkedHashSet<>();

    @OneToOne(mappedBy = "user")
    private AuthtokenToken authtokenToken;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsCorrespondent> documentsCorrespondents = new LinkedHashSet<>();

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsDocument> documentsDocuments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsDocumenttype> documentsDocumenttypes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<DocumentsNote> documentsNotes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsSavedview> documentsSavedviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsStoragepath> documentsStoragepaths = new LinkedHashSet<>();

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsTag> documentsTags = new LinkedHashSet<>();

    @OneToOne(mappedBy = "user")
    private DocumentsUisetting documentsUisetting;

    @OneToMany(mappedBy = "owner")
    private Set<PaperlessMailMailaccount> paperlessMailMailaccounts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "owner")
    private Set<PaperlessMailMailrule> paperlessMailMailrules = new LinkedHashSet<>();

    @OneToMany(mappedBy = "owner")
    private Set<PaperlessMailProcessedmail> paperlessMailProcessedmails = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OffsetDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(OffsetDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public OffsetDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(OffsetDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Set<AuthUserGroup> getAuthUserGroups() {
        return authUserGroups;
    }

    public void setAuthUserGroups(Set<AuthUserGroup> authUserGroups) {
        this.authUserGroups = authUserGroups;
    }

    public Set<AuthUserUserPermission> getAuthUserUserPermissions() {
        return authUserUserPermissions;
    }

    public void setAuthUserUserPermissions(Set<AuthUserUserPermission> authUserUserPermissions) {
        this.authUserUserPermissions = authUserUserPermissions;
    }

    public AuthtokenToken getAuthtokenToken() {
        return authtokenToken;
    }

    public void setAuthtokenToken(AuthtokenToken authtokenToken) {
        this.authtokenToken = authtokenToken;
    }

    public Set<DocumentsCorrespondent> getDocumentsCorrespondents() {
        return documentsCorrespondents;
    }

    public void setDocumentsCorrespondents(Set<DocumentsCorrespondent> documentsCorrespondents) {
        this.documentsCorrespondents = documentsCorrespondents;
    }

    public Set<DocumentsDocument> getDocumentsDocuments() {
        return documentsDocuments;
    }

    public void setDocumentsDocuments(Set<DocumentsDocument> documentsDocuments) {
        this.documentsDocuments = documentsDocuments;
    }

    public Set<DocumentsDocumenttype> getDocumentsDocumenttypes() {
        return documentsDocumenttypes;
    }

    public void setDocumentsDocumenttypes(Set<DocumentsDocumenttype> documentsDocumenttypes) {
        this.documentsDocumenttypes = documentsDocumenttypes;
    }

    public Set<DocumentsNote> getDocumentsNotes() {
        return documentsNotes;
    }

    public void setDocumentsNotes(Set<DocumentsNote> documentsNotes) {
        this.documentsNotes = documentsNotes;
    }

    public Set<DocumentsSavedview> getDocumentsSavedviews() {
        return documentsSavedviews;
    }

    public void setDocumentsSavedviews(Set<DocumentsSavedview> documentsSavedviews) {
        this.documentsSavedviews = documentsSavedviews;
    }

    public Set<DocumentsStoragepath> getDocumentsStoragepaths() {
        return documentsStoragepaths;
    }

    public void setDocumentsStoragepaths(Set<DocumentsStoragepath> documentsStoragepaths) {
        this.documentsStoragepaths = documentsStoragepaths;
    }

    public Set<DocumentsTag> getDocumentsTags() {
        return documentsTags;
    }

    public void setDocumentsTags(Set<DocumentsTag> documentsTags) {
        this.documentsTags = documentsTags;
    }

    public DocumentsUisetting getDocumentsUisetting() {
        return documentsUisetting;
    }

    public void setDocumentsUisetting(DocumentsUisetting documentsUisetting) {
        this.documentsUisetting = documentsUisetting;
    }

    public Set<PaperlessMailMailaccount> getPaperlessMailMailaccounts() {
        return paperlessMailMailaccounts;
    }

    public void setPaperlessMailMailaccounts(Set<PaperlessMailMailaccount> paperlessMailMailaccounts) {
        this.paperlessMailMailaccounts = paperlessMailMailaccounts;
    }

    public Set<PaperlessMailMailrule> getPaperlessMailMailrules() {
        return paperlessMailMailrules;
    }

    public void setPaperlessMailMailrules(Set<PaperlessMailMailrule> paperlessMailMailrules) {
        this.paperlessMailMailrules = paperlessMailMailrules;
    }

    public Set<PaperlessMailProcessedmail> getPaperlessMailProcessedmails() {
        return paperlessMailProcessedmails;
    }

    public void setPaperlessMailProcessedmails(Set<PaperlessMailProcessedmail> paperlessMailProcessedmails) {
        this.paperlessMailProcessedmails = paperlessMailProcessedmails;
    }

}