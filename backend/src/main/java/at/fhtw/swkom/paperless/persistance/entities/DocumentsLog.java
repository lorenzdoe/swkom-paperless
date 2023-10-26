package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "documents_log")
public class DocumentsLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "\"group\"")
    private UUID group;

    @NotNull
    @Column(name = "message", nullable = false, length = Integer.MAX_VALUE)
    private String message;

    @NotNull
    @Column(name = "level", nullable = false)
    private Integer level;

    @NotNull
    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getGroup() {
        return group;
    }

    public void setGroup(UUID group) {
        this.group = group;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

}