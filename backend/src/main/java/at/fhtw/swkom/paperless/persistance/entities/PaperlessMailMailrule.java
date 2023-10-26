package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "paperless_mail_mailrule", indexes = {
        @Index(name = "paperless_mail_mailrule_name_ee9b53bd_uniq", columnList = "name", unique = true),
        @Index(name = "paperless_mail_mailrule_name_ee9b53bd_like", columnList = "name"),
        @Index(name = "paperless_mail_mailrule_account_id_461903f4", columnList = "account_id"),
        @Index(name = "paperless_mail_mailrule_assign_correspondent_id_d2651486", columnList = "assign_correspondent_id"),
        @Index(name = "paperless_mail_mailrule_assign_document_type_id_cb809476", columnList = "assign_document_type_id"),
        @Index(name = "paperless_mail_mailrule_owner_id_05d1c50f", columnList = "owner_id")
})
public class PaperlessMailMailrule {
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
    @Column(name = "folder", nullable = false, length = 256)
    private String folder;

    @Size(max = 256)
    @Column(name = "filter_from", length = 256)
    private String filterFrom;

    @Size(max = 256)
    @Column(name = "filter_subject", length = 256)
    private String filterSubject;

    @Size(max = 256)
    @Column(name = "filter_body", length = 256)
    private String filterBody;

    @NotNull
    @Column(name = "maximum_age", nullable = false)
    private Integer maximumAge;

    @NotNull
    @Column(name = "action", nullable = false)
    private Integer action;

    @Size(max = 256)
    @Column(name = "action_parameter", length = 256)
    private String actionParameter;

    @NotNull
    @Column(name = "assign_title_from", nullable = false)
    private Integer assignTitleFrom;

    @NotNull
    @Column(name = "assign_correspondent_from", nullable = false)
    private Integer assignCorrespondentFrom;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private PaperlessMailMailaccount account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_correspondent_id")
    private DocumentsCorrespondent assignCorrespondent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_document_type_id")
    private DocumentsDocumenttype assignDocumentType;

    @NotNull
    @Column(name = "\"order\"", nullable = false)
    private Integer order;

    @NotNull
    @Column(name = "attachment_type", nullable = false)
    private Integer attachmentType;

    @Size(max = 256)
    @Column(name = "filter_attachment_filename", length = 256)
    private String filterAttachmentFilename;

    @NotNull
    @Column(name = "consumption_scope", nullable = false)
    private Integer consumptionScope;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @Size(max = 256)
    @Column(name = "filter_to", length = 256)
    private String filterTo;

    @OneToMany(mappedBy = "mailrule")
    private Set<PaperlessMailMailruleAssignTag> paperlessMailMailruleAssignTags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "rule")
    private Set<PaperlessMailProcessedmail> paperlessMailProcessedmails = new LinkedHashSet<>();

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

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFilterFrom() {
        return filterFrom;
    }

    public void setFilterFrom(String filterFrom) {
        this.filterFrom = filterFrom;
    }

    public String getFilterSubject() {
        return filterSubject;
    }

    public void setFilterSubject(String filterSubject) {
        this.filterSubject = filterSubject;
    }

    public String getFilterBody() {
        return filterBody;
    }

    public void setFilterBody(String filterBody) {
        this.filterBody = filterBody;
    }

    public Integer getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(Integer maximumAge) {
        this.maximumAge = maximumAge;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getActionParameter() {
        return actionParameter;
    }

    public void setActionParameter(String actionParameter) {
        this.actionParameter = actionParameter;
    }

    public Integer getAssignTitleFrom() {
        return assignTitleFrom;
    }

    public void setAssignTitleFrom(Integer assignTitleFrom) {
        this.assignTitleFrom = assignTitleFrom;
    }

    public Integer getAssignCorrespondentFrom() {
        return assignCorrespondentFrom;
    }

    public void setAssignCorrespondentFrom(Integer assignCorrespondentFrom) {
        this.assignCorrespondentFrom = assignCorrespondentFrom;
    }

    public PaperlessMailMailaccount getAccount() {
        return account;
    }

    public void setAccount(PaperlessMailMailaccount account) {
        this.account = account;
    }

    public DocumentsCorrespondent getAssignCorrespondent() {
        return assignCorrespondent;
    }

    public void setAssignCorrespondent(DocumentsCorrespondent assignCorrespondent) {
        this.assignCorrespondent = assignCorrespondent;
    }

    public DocumentsDocumenttype getAssignDocumentType() {
        return assignDocumentType;
    }

    public void setAssignDocumentType(DocumentsDocumenttype assignDocumentType) {
        this.assignDocumentType = assignDocumentType;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(Integer attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getFilterAttachmentFilename() {
        return filterAttachmentFilename;
    }

    public void setFilterAttachmentFilename(String filterAttachmentFilename) {
        this.filterAttachmentFilename = filterAttachmentFilename;
    }

    public Integer getConsumptionScope() {
        return consumptionScope;
    }

    public void setConsumptionScope(Integer consumptionScope) {
        this.consumptionScope = consumptionScope;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

    public String getFilterTo() {
        return filterTo;
    }

    public void setFilterTo(String filterTo) {
        this.filterTo = filterTo;
    }

    public Set<PaperlessMailMailruleAssignTag> getPaperlessMailMailruleAssignTags() {
        return paperlessMailMailruleAssignTags;
    }

    public void setPaperlessMailMailruleAssignTags(Set<PaperlessMailMailruleAssignTag> paperlessMailMailruleAssignTags) {
        this.paperlessMailMailruleAssignTags = paperlessMailMailruleAssignTags;
    }

    public Set<PaperlessMailProcessedmail> getPaperlessMailProcessedmails() {
        return paperlessMailProcessedmails;
    }

    public void setPaperlessMailProcessedmails(Set<PaperlessMailProcessedmail> paperlessMailProcessedmails) {
        this.paperlessMailProcessedmails = paperlessMailProcessedmails;
    }

}