package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailrule}
 */
@Getter
@Builder
public class PaperlessMailMailruleDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 256)
    private String name;
    @NotNull
    @Size(max = 256)
    private String folder;
    @Size(max = 256)
    private String filterFrom;
    @Size(max = 256)
    private String filterSubject;
    @Size(max = 256)
    private String filterBody;
    @NotNull
    private Integer maximumAge;
    @NotNull
    private Integer action;
    @Size(max = 256)
    private String actionParameter;
    @NotNull
    private Integer assignTitleFrom;
    @NotNull
    private Integer assignCorrespondentFrom;
    @NotNull
    private PaperlessMailMailaccountDto account;
    private DocumentsCorrespondentDto assignCorrespondent;
    private DocumentsDocumenttypeDto assignDocumentType;
    @NotNull
    private Integer order;
    @NotNull
    private Integer attachmentType;
    @Size(max = 256)
    private String filterAttachmentFilename;
    @NotNull
    private Integer consumptionScope;
    private AuthUserDto owner;
    @Size(max = 256)
    private String filterTo;
    private Set<PaperlessMailMailruleAssignTagDto> paperlessMailMailruleAssignTags = new LinkedHashSet<>();
    private Set<PaperlessMailProcessedmailDto> paperlessMailProcessedmails = new LinkedHashSet<>();

    public PaperlessMailMailruleDto() {
    }

    public PaperlessMailMailruleDto(Integer id, String name, String folder, String filterFrom, String filterSubject, String filterBody, Integer maximumAge, Integer action, String actionParameter, Integer assignTitleFrom, Integer assignCorrespondentFrom, PaperlessMailMailaccountDto account, DocumentsCorrespondentDto assignCorrespondent, DocumentsDocumenttypeDto assignDocumentType, Integer order, Integer attachmentType, String filterAttachmentFilename, Integer consumptionScope, AuthUserDto owner, String filterTo, Set<PaperlessMailMailruleAssignTagDto> paperlessMailMailruleAssignTags, Set<PaperlessMailProcessedmailDto> paperlessMailProcessedmails) {
        this.id = id;
        this.name = name;
        this.folder = folder;
        this.filterFrom = filterFrom;
        this.filterSubject = filterSubject;
        this.filterBody = filterBody;
        this.maximumAge = maximumAge;
        this.action = action;
        this.actionParameter = actionParameter;
        this.assignTitleFrom = assignTitleFrom;
        this.assignCorrespondentFrom = assignCorrespondentFrom;
        this.account = account;
        this.assignCorrespondent = assignCorrespondent;
        this.assignDocumentType = assignDocumentType;
        this.order = order;
        this.attachmentType = attachmentType;
        this.filterAttachmentFilename = filterAttachmentFilename;
        this.consumptionScope = consumptionScope;
        this.owner = owner;
        this.filterTo = filterTo;
        this.paperlessMailMailruleAssignTags = paperlessMailMailruleAssignTags;
        this.paperlessMailProcessedmails = paperlessMailProcessedmails;
    }

    public PaperlessMailMailruleDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public PaperlessMailMailruleDto setName(String name) {
        this.name = name;
        return this;
    }

    public PaperlessMailMailruleDto setFolder(String folder) {
        this.folder = folder;
        return this;
    }

    public PaperlessMailMailruleDto setFilterFrom(String filterFrom) {
        this.filterFrom = filterFrom;
        return this;
    }

    public PaperlessMailMailruleDto setFilterSubject(String filterSubject) {
        this.filterSubject = filterSubject;
        return this;
    }

    public PaperlessMailMailruleDto setFilterBody(String filterBody) {
        this.filterBody = filterBody;
        return this;
    }

    public PaperlessMailMailruleDto setMaximumAge(Integer maximumAge) {
        this.maximumAge = maximumAge;
        return this;
    }

    public PaperlessMailMailruleDto setAction(Integer action) {
        this.action = action;
        return this;
    }

    public PaperlessMailMailruleDto setActionParameter(String actionParameter) {
        this.actionParameter = actionParameter;
        return this;
    }

    public PaperlessMailMailruleDto setAssignTitleFrom(Integer assignTitleFrom) {
        this.assignTitleFrom = assignTitleFrom;
        return this;
    }

    public PaperlessMailMailruleDto setAssignCorrespondentFrom(Integer assignCorrespondentFrom) {
        this.assignCorrespondentFrom = assignCorrespondentFrom;
        return this;
    }

    public PaperlessMailMailruleDto setAccount(PaperlessMailMailaccountDto account) {
        this.account = account;
        return this;
    }

    public PaperlessMailMailruleDto setAssignCorrespondent(DocumentsCorrespondentDto assignCorrespondent) {
        this.assignCorrespondent = assignCorrespondent;
        return this;
    }

    public PaperlessMailMailruleDto setAssignDocumentType(DocumentsDocumenttypeDto assignDocumentType) {
        this.assignDocumentType = assignDocumentType;
        return this;
    }

    public PaperlessMailMailruleDto setOrder(Integer order) {
        this.order = order;
        return this;
    }

    public PaperlessMailMailruleDto setAttachmentType(Integer attachmentType) {
        this.attachmentType = attachmentType;
        return this;
    }

    public PaperlessMailMailruleDto setFilterAttachmentFilename(String filterAttachmentFilename) {
        this.filterAttachmentFilename = filterAttachmentFilename;
        return this;
    }

    public PaperlessMailMailruleDto setConsumptionScope(Integer consumptionScope) {
        this.consumptionScope = consumptionScope;
        return this;
    }

    public PaperlessMailMailruleDto setOwner(AuthUserDto owner) {
        this.owner = owner;
        return this;
    }

    public PaperlessMailMailruleDto setFilterTo(String filterTo) {
        this.filterTo = filterTo;
        return this;
    }

    public PaperlessMailMailruleDto setPaperlessMailMailruleAssignTags(Set<PaperlessMailMailruleAssignTagDto> paperlessMailMailruleAssignTags) {
        this.paperlessMailMailruleAssignTags = paperlessMailMailruleAssignTags;
        return this;
    }

    public PaperlessMailMailruleDto setPaperlessMailProcessedmails(Set<PaperlessMailProcessedmailDto> paperlessMailProcessedmails) {
        this.paperlessMailProcessedmails = paperlessMailProcessedmails;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperlessMailMailruleDto entity = (PaperlessMailMailruleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.folder, entity.folder) &&
                Objects.equals(this.filterFrom, entity.filterFrom) &&
                Objects.equals(this.filterSubject, entity.filterSubject) &&
                Objects.equals(this.filterBody, entity.filterBody) &&
                Objects.equals(this.maximumAge, entity.maximumAge) &&
                Objects.equals(this.action, entity.action) &&
                Objects.equals(this.actionParameter, entity.actionParameter) &&
                Objects.equals(this.assignTitleFrom, entity.assignTitleFrom) &&
                Objects.equals(this.assignCorrespondentFrom, entity.assignCorrespondentFrom) &&
                Objects.equals(this.account, entity.account) &&
                Objects.equals(this.assignCorrespondent, entity.assignCorrespondent) &&
                Objects.equals(this.assignDocumentType, entity.assignDocumentType) &&
                Objects.equals(this.order, entity.order) &&
                Objects.equals(this.attachmentType, entity.attachmentType) &&
                Objects.equals(this.filterAttachmentFilename, entity.filterAttachmentFilename) &&
                Objects.equals(this.consumptionScope, entity.consumptionScope) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.filterTo, entity.filterTo) &&
                Objects.equals(this.paperlessMailMailruleAssignTags, entity.paperlessMailMailruleAssignTags) &&
                Objects.equals(this.paperlessMailProcessedmails, entity.paperlessMailProcessedmails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, folder, filterFrom, filterSubject, filterBody, maximumAge, action, actionParameter, assignTitleFrom, assignCorrespondentFrom, account, assignCorrespondent, assignDocumentType, order, attachmentType, filterAttachmentFilename, consumptionScope, owner, filterTo, paperlessMailMailruleAssignTags, paperlessMailProcessedmails);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "folder = " + folder + ", " +
                "filterFrom = " + filterFrom + ", " +
                "filterSubject = " + filterSubject + ", " +
                "filterBody = " + filterBody + ", " +
                "maximumAge = " + maximumAge + ", " +
                "action = " + action + ", " +
                "actionParameter = " + actionParameter + ", " +
                "assignTitleFrom = " + assignTitleFrom + ", " +
                "assignCorrespondentFrom = " + assignCorrespondentFrom + ", " +
                "account = " + account + ", " +
                "assignCorrespondent = " + assignCorrespondent + ", " +
                "assignDocumentType = " + assignDocumentType + ", " +
                "order = " + order + ", " +
                "attachmentType = " + attachmentType + ", " +
                "filterAttachmentFilename = " + filterAttachmentFilename + ", " +
                "consumptionScope = " + consumptionScope + ", " +
                "owner = " + owner + ", " +
                "filterTo = " + filterTo + ", " +
                "paperlessMailMailruleAssignTags = " + paperlessMailMailruleAssignTags + ", " +
                "paperlessMailProcessedmails = " + paperlessMailProcessedmails + ")";
    }
}