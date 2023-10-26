package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;

@Entity
@Table(name = "paperless_mail_processedmail", indexes = {
        @Index(name = "paperless_mail_processedmail_owner_id_63d8ece4", columnList = "owner_id"),
        @Index(name = "paperless_mail_processedmail_rule_id_55bb3322", columnList = "rule_id")
})
public class PaperlessMailProcessedmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 256)
    @NotNull
    @Column(name = "folder", nullable = false, length = 256)
    private String folder;

    @Size(max = 256)
    @NotNull
    @Column(name = "uid", nullable = false, length = 256)
    private String uid;

    @Size(max = 256)
    @NotNull
    @Column(name = "subject", nullable = false, length = 256)
    private String subject;

    @NotNull
    @Column(name = "received", nullable = false)
    private OffsetDateTime received;

    @NotNull
    @Column(name = "processed", nullable = false)
    private OffsetDateTime processed;

    @Size(max = 256)
    @NotNull
    @Column(name = "status", nullable = false, length = 256)
    private String status;

    @Column(name = "error", length = Integer.MAX_VALUE)
    private String error;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rule_id", nullable = false)
    private PaperlessMailMailrule rule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public OffsetDateTime getReceived() {
        return received;
    }

    public void setReceived(OffsetDateTime received) {
        this.received = received;
    }

    public OffsetDateTime getProcessed() {
        return processed;
    }

    public void setProcessed(OffsetDateTime processed) {
        this.processed = processed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

    public PaperlessMailMailrule getRule() {
        return rule;
    }

    public void setRule(PaperlessMailMailrule rule) {
        this.rule = rule;
    }

}