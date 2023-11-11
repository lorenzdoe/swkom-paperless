package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.PaperlessMailProcessedmail}
 */
@Getter
@Builder
public class PaperlessMailProcessedmailDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 256)
    private String folder;
    @NotNull
    @Size(max = 256)
    private String uid;
    @NotNull
    @Size(max = 256)
    private String subject;
    @NotNull
    private OffsetDateTime received;
    @NotNull
    private OffsetDateTime processed;
    @NotNull
    @Size(max = 256)
    private String status;
    private String error;
    private AuthUserDto owner;
    @NotNull
    private PaperlessMailMailruleDto rule;

    public PaperlessMailProcessedmailDto() {
    }

    public PaperlessMailProcessedmailDto(Integer id, String folder, String uid, String subject, OffsetDateTime received, OffsetDateTime processed, String status, String error, AuthUserDto owner, PaperlessMailMailruleDto rule) {
        this.id = id;
        this.folder = folder;
        this.uid = uid;
        this.subject = subject;
        this.received = received;
        this.processed = processed;
        this.status = status;
        this.error = error;
        this.owner = owner;
        this.rule = rule;
    }

    public PaperlessMailProcessedmailDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public PaperlessMailProcessedmailDto setFolder(String folder) {
        this.folder = folder;
        return this;
    }

    public PaperlessMailProcessedmailDto setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public PaperlessMailProcessedmailDto setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public PaperlessMailProcessedmailDto setReceived(OffsetDateTime received) {
        this.received = received;
        return this;
    }

    public PaperlessMailProcessedmailDto setProcessed(OffsetDateTime processed) {
        this.processed = processed;
        return this;
    }

    public PaperlessMailProcessedmailDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public PaperlessMailProcessedmailDto setError(String error) {
        this.error = error;
        return this;
    }

    public PaperlessMailProcessedmailDto setOwner(AuthUserDto owner) {
        this.owner = owner;
        return this;
    }

    public PaperlessMailProcessedmailDto setRule(PaperlessMailMailruleDto rule) {
        this.rule = rule;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperlessMailProcessedmailDto entity = (PaperlessMailProcessedmailDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.folder, entity.folder) &&
                Objects.equals(this.uid, entity.uid) &&
                Objects.equals(this.subject, entity.subject) &&
                Objects.equals(this.received, entity.received) &&
                Objects.equals(this.processed, entity.processed) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.error, entity.error) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.rule, entity.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, folder, uid, subject, received, processed, status, error, owner, rule);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "folder = " + folder + ", " +
                "uid = " + uid + ", " +
                "subject = " + subject + ", " +
                "received = " + received + ", " +
                "processed = " + processed + ", " +
                "status = " + status + ", " +
                "error = " + error + ", " +
                "owner = " + owner + ", " +
                "rule = " + rule + ")";
    }
}