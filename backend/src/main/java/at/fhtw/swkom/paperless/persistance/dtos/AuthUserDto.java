package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.AuthUser}
 */
@Getter
@Builder
public class AuthUserDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 128)
    private String password;
    private OffsetDateTime lastLogin;
    @NotNull
    private Boolean isSuperuser = false;
    @NotNull
    @Size(max = 150)
    private String username;
    @NotNull
    @Size(max = 150)
    private String firstName;
    @NotNull
    @Size(max = 150)
    private String lastName;
    @NotNull
    @Size(max = 254)
    private String email;
    @NotNull
    private Boolean isStaff = false;
    @NotNull
    private Boolean isActive = false;
    @NotNull
    private OffsetDateTime dateJoined;
    private Set<AuthUserGroupDto> authUserGroups = new LinkedHashSet<>();
    private Set<AuthUserUserPermissionDto> authUserUserPermissions = new LinkedHashSet<>();
    private AuthtokenTokenDto authtokenToken;
    private Set<DocumentsCorrespondentDto> documentsCorrespondents = new LinkedHashSet<>();
    private Set<DocumentsDocumentDto> documentsDocuments = new LinkedHashSet<>();
    private Set<DocumentsDocumenttypeDto> documentsDocumenttypes = new LinkedHashSet<>();
    private Set<DocumentsNoteDto> documentsNotes = new LinkedHashSet<>();
    private Set<DocumentsSavedviewDto> documentsSavedviews = new LinkedHashSet<>();
    private Set<DocumentsStoragepathDto> documentsStoragepaths = new LinkedHashSet<>();
    private Set<DocumentsTagDto> documentsTags = new LinkedHashSet<>();
    private DocumentsUisettingDto documentsUisetting;
    private Set<PaperlessMailMailaccountDto> paperlessMailMailaccounts = new LinkedHashSet<>();
    private Set<PaperlessMailMailruleDto> paperlessMailMailrules = new LinkedHashSet<>();
    private Set<PaperlessMailProcessedmailDto> paperlessMailProcessedmails = new LinkedHashSet<>();

    public AuthUserDto() {
    }

    public AuthUserDto(Integer id, String password, OffsetDateTime lastLogin, Boolean isSuperuser, String username, String firstName, String lastName, String email, Boolean isStaff, Boolean isActive, OffsetDateTime dateJoined, Set<AuthUserGroupDto> authUserGroups, Set<AuthUserUserPermissionDto> authUserUserPermissions, AuthtokenTokenDto authtokenToken, Set<DocumentsCorrespondentDto> documentsCorrespondents, Set<DocumentsDocumentDto> documentsDocuments, Set<DocumentsDocumenttypeDto> documentsDocumenttypes, Set<DocumentsNoteDto> documentsNotes, Set<DocumentsSavedviewDto> documentsSavedviews, Set<DocumentsStoragepathDto> documentsStoragepaths, Set<DocumentsTagDto> documentsTags, DocumentsUisettingDto documentsUisetting, Set<PaperlessMailMailaccountDto> paperlessMailMailaccounts, Set<PaperlessMailMailruleDto> paperlessMailMailrules, Set<PaperlessMailProcessedmailDto> paperlessMailProcessedmails) {
        this.id = id;
        this.password = password;
        this.lastLogin = lastLogin;
        this.isSuperuser = isSuperuser;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isStaff = isStaff;
        this.isActive = isActive;
        this.dateJoined = dateJoined;
        this.authUserGroups = authUserGroups;
        this.authUserUserPermissions = authUserUserPermissions;
        this.authtokenToken = authtokenToken;
        this.documentsCorrespondents = documentsCorrespondents;
        this.documentsDocuments = documentsDocuments;
        this.documentsDocumenttypes = documentsDocumenttypes;
        this.documentsNotes = documentsNotes;
        this.documentsSavedviews = documentsSavedviews;
        this.documentsStoragepaths = documentsStoragepaths;
        this.documentsTags = documentsTags;
        this.documentsUisetting = documentsUisetting;
        this.paperlessMailMailaccounts = paperlessMailMailaccounts;
        this.paperlessMailMailrules = paperlessMailMailrules;
        this.paperlessMailProcessedmails = paperlessMailProcessedmails;
    }

    public AuthUserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public AuthUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public AuthUserDto setLastLogin(OffsetDateTime lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public AuthUserDto setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
        return this;
    }

    public AuthUserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public AuthUserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AuthUserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AuthUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public AuthUserDto setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
        return this;
    }

    public AuthUserDto setIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public AuthUserDto setDateJoined(OffsetDateTime dateJoined) {
        this.dateJoined = dateJoined;
        return this;
    }

    public AuthUserDto setAuthUserGroups(Set<AuthUserGroupDto> authUserGroups) {
        this.authUserGroups = authUserGroups;
        return this;
    }

    public AuthUserDto setAuthUserUserPermissions(Set<AuthUserUserPermissionDto> authUserUserPermissions) {
        this.authUserUserPermissions = authUserUserPermissions;
        return this;
    }

    public AuthUserDto setAuthtokenToken(AuthtokenTokenDto authtokenToken) {
        this.authtokenToken = authtokenToken;
        return this;
    }

    public AuthUserDto setDocumentsCorrespondents(Set<DocumentsCorrespondentDto> documentsCorrespondents) {
        this.documentsCorrespondents = documentsCorrespondents;
        return this;
    }

    public AuthUserDto setDocumentsDocuments(Set<DocumentsDocumentDto> documentsDocuments) {
        this.documentsDocuments = documentsDocuments;
        return this;
    }

    public AuthUserDto setDocumentsDocumenttypes(Set<DocumentsDocumenttypeDto> documentsDocumenttypes) {
        this.documentsDocumenttypes = documentsDocumenttypes;
        return this;
    }

    public AuthUserDto setDocumentsNotes(Set<DocumentsNoteDto> documentsNotes) {
        this.documentsNotes = documentsNotes;
        return this;
    }

    public AuthUserDto setDocumentsSavedviews(Set<DocumentsSavedviewDto> documentsSavedviews) {
        this.documentsSavedviews = documentsSavedviews;
        return this;
    }

    public AuthUserDto setDocumentsStoragepaths(Set<DocumentsStoragepathDto> documentsStoragepaths) {
        this.documentsStoragepaths = documentsStoragepaths;
        return this;
    }

    public AuthUserDto setDocumentsTags(Set<DocumentsTagDto> documentsTags) {
        this.documentsTags = documentsTags;
        return this;
    }

    public AuthUserDto setDocumentsUisetting(DocumentsUisettingDto documentsUisetting) {
        this.documentsUisetting = documentsUisetting;
        return this;
    }

    public AuthUserDto setPaperlessMailMailaccounts(Set<PaperlessMailMailaccountDto> paperlessMailMailaccounts) {
        this.paperlessMailMailaccounts = paperlessMailMailaccounts;
        return this;
    }

    public AuthUserDto setPaperlessMailMailrules(Set<PaperlessMailMailruleDto> paperlessMailMailrules) {
        this.paperlessMailMailrules = paperlessMailMailrules;
        return this;
    }

    public AuthUserDto setPaperlessMailProcessedmails(Set<PaperlessMailProcessedmailDto> paperlessMailProcessedmails) {
        this.paperlessMailProcessedmails = paperlessMailProcessedmails;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUserDto entity = (AuthUserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.lastLogin, entity.lastLogin) &&
                Objects.equals(this.isSuperuser, entity.isSuperuser) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.isStaff, entity.isStaff) &&
                Objects.equals(this.isActive, entity.isActive) &&
                Objects.equals(this.dateJoined, entity.dateJoined) &&
                Objects.equals(this.authUserGroups, entity.authUserGroups) &&
                Objects.equals(this.authUserUserPermissions, entity.authUserUserPermissions) &&
                Objects.equals(this.authtokenToken, entity.authtokenToken) &&
                Objects.equals(this.documentsCorrespondents, entity.documentsCorrespondents) &&
                Objects.equals(this.documentsDocuments, entity.documentsDocuments) &&
                Objects.equals(this.documentsDocumenttypes, entity.documentsDocumenttypes) &&
                Objects.equals(this.documentsNotes, entity.documentsNotes) &&
                Objects.equals(this.documentsSavedviews, entity.documentsSavedviews) &&
                Objects.equals(this.documentsStoragepaths, entity.documentsStoragepaths) &&
                Objects.equals(this.documentsTags, entity.documentsTags) &&
                Objects.equals(this.documentsUisetting, entity.documentsUisetting) &&
                Objects.equals(this.paperlessMailMailaccounts, entity.paperlessMailMailaccounts) &&
                Objects.equals(this.paperlessMailMailrules, entity.paperlessMailMailrules) &&
                Objects.equals(this.paperlessMailProcessedmails, entity.paperlessMailProcessedmails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, lastLogin, isSuperuser, username, firstName, lastName, email, isStaff, isActive, dateJoined, authUserGroups, authUserUserPermissions, authtokenToken, documentsCorrespondents, documentsDocuments, documentsDocumenttypes, documentsNotes, documentsSavedviews, documentsStoragepaths, documentsTags, documentsUisetting, paperlessMailMailaccounts, paperlessMailMailrules, paperlessMailProcessedmails);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "password = " + password + ", " +
                "lastLogin = " + lastLogin + ", " +
                "isSuperuser = " + isSuperuser + ", " +
                "username = " + username + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +
                "isStaff = " + isStaff + ", " +
                "isActive = " + isActive + ", " +
                "dateJoined = " + dateJoined + ", " +
                "authUserGroups = " + authUserGroups + ", " +
                "authUserUserPermissions = " + authUserUserPermissions + ", " +
                "authtokenToken = " + authtokenToken + ", " +
                "documentsCorrespondents = " + documentsCorrespondents + ", " +
                "documentsDocuments = " + documentsDocuments + ", " +
                "documentsDocumenttypes = " + documentsDocumenttypes + ", " +
                "documentsNotes = " + documentsNotes + ", " +
                "documentsSavedviews = " + documentsSavedviews + ", " +
                "documentsStoragepaths = " + documentsStoragepaths + ", " +
                "documentsTags = " + documentsTags + ", " +
                "documentsUisetting = " + documentsUisetting + ", " +
                "paperlessMailMailaccounts = " + paperlessMailMailaccounts + ", " +
                "paperlessMailMailrules = " + paperlessMailMailrules + ", " +
                "paperlessMailProcessedmails = " + paperlessMailProcessedmails + ")";
    }
}