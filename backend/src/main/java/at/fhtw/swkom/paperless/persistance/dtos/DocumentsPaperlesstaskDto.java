package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsPaperlesstask}
 */
public class DocumentsPaperlesstaskDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String taskId;
    @NotNull
    private Boolean acknowledged = false;
    private OffsetDateTime dateCreated;
    private OffsetDateTime dateDone;
    private OffsetDateTime dateStarted;
    private String result;
    @NotNull
    @Size(max = 30)
    private String status;
    @Size(max = 255)
    private String taskFileName;
    @Size(max = 255)
    private String taskName;

    public DocumentsPaperlesstaskDto() {
    }

    public DocumentsPaperlesstaskDto(Integer id, String taskId, Boolean acknowledged, OffsetDateTime dateCreated, OffsetDateTime dateDone, OffsetDateTime dateStarted, String result, String status, String taskFileName, String taskName) {
        this.id = id;
        this.taskId = taskId;
        this.acknowledged = acknowledged;
        this.dateCreated = dateCreated;
        this.dateDone = dateDone;
        this.dateStarted = dateStarted;
        this.result = result;
        this.status = status;
        this.taskFileName = taskFileName;
        this.taskName = taskName;
    }

    public Integer getId() {
        return id;
    }

    public DocumentsPaperlesstaskDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTaskId() {
        return taskId;
    }

    public DocumentsPaperlesstaskDto setTaskId(String taskId) {
        this.taskId = taskId;
        return this;
    }

    public Boolean getAcknowledged() {
        return acknowledged;
    }

    public DocumentsPaperlesstaskDto setAcknowledged(Boolean acknowledged) {
        this.acknowledged = acknowledged;
        return this;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public DocumentsPaperlesstaskDto setDateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public OffsetDateTime getDateDone() {
        return dateDone;
    }

    public DocumentsPaperlesstaskDto setDateDone(OffsetDateTime dateDone) {
        this.dateDone = dateDone;
        return this;
    }

    public OffsetDateTime getDateStarted() {
        return dateStarted;
    }

    public DocumentsPaperlesstaskDto setDateStarted(OffsetDateTime dateStarted) {
        this.dateStarted = dateStarted;
        return this;
    }

    public String getResult() {
        return result;
    }

    public DocumentsPaperlesstaskDto setResult(String result) {
        this.result = result;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public DocumentsPaperlesstaskDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getTaskFileName() {
        return taskFileName;
    }

    public DocumentsPaperlesstaskDto setTaskFileName(String taskFileName) {
        this.taskFileName = taskFileName;
        return this;
    }

    public String getTaskName() {
        return taskName;
    }

    public DocumentsPaperlesstaskDto setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsPaperlesstaskDto entity = (DocumentsPaperlesstaskDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.taskId, entity.taskId) &&
                Objects.equals(this.acknowledged, entity.acknowledged) &&
                Objects.equals(this.dateCreated, entity.dateCreated) &&
                Objects.equals(this.dateDone, entity.dateDone) &&
                Objects.equals(this.dateStarted, entity.dateStarted) &&
                Objects.equals(this.result, entity.result) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.taskFileName, entity.taskFileName) &&
                Objects.equals(this.taskName, entity.taskName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskId, acknowledged, dateCreated, dateDone, dateStarted, result, status, taskFileName, taskName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "taskId = " + taskId + ", " +
                "acknowledged = " + acknowledged + ", " +
                "dateCreated = " + dateCreated + ", " +
                "dateDone = " + dateDone + ", " +
                "dateStarted = " + dateStarted + ", " +
                "result = " + result + ", " +
                "status = " + status + ", " +
                "taskFileName = " + taskFileName + ", " +
                "taskName = " + taskName + ")";
    }
}