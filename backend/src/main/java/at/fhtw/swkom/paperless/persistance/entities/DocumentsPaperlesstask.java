package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;

@Entity
@Table(name = "documents_paperlesstask", indexes = {
        @Index(name = "documents_paperlesstask_task_id_24b393f9_uniq", columnList = "task_id", unique = true),
        @Index(name = "documents_paperlesstask_task_id_24b393f9_like", columnList = "task_id")
})
public class DocumentsPaperlesstask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "task_id", nullable = false)
    private String taskId;

    @NotNull
    @Column(name = "acknowledged", nullable = false)
    private Boolean acknowledged = false;

    @Column(name = "date_created")
    private OffsetDateTime dateCreated;

    @Column(name = "date_done")
    private OffsetDateTime dateDone;

    @Column(name = "date_started")
    private OffsetDateTime dateStarted;

    @Column(name = "result", length = Integer.MAX_VALUE)
    private String result;

    @Size(max = 30)
    @NotNull
    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @Size(max = 255)
    @Column(name = "task_file_name")
    private String taskFileName;

    @Size(max = 255)
    @Column(name = "task_name")
    private String taskName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Boolean getAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(Boolean acknowledged) {
        this.acknowledged = acknowledged;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getDateDone() {
        return dateDone;
    }

    public void setDateDone(OffsetDateTime dateDone) {
        this.dateDone = dateDone;
    }

    public OffsetDateTime getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(OffsetDateTime dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskFileName() {
        return taskFileName;
    }

    public void setTaskFileName(String taskFileName) {
        this.taskFileName = taskFileName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

}