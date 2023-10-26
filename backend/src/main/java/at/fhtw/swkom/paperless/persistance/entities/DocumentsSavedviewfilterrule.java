package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "documents_savedviewfilterrule", indexes = {
        @Index(name = "documents_savedviewfilterrule_saved_view_id_038e2c89", columnList = "saved_view_id")
})
public class DocumentsSavedviewfilterrule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "rule_type", nullable = false)
    private Integer ruleType;

    @Size(max = 255)
    @Column(name = "value")
    private String value;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "saved_view_id", nullable = false)
    private DocumentsSavedview savedView;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DocumentsSavedview getSavedView() {
        return savedView;
    }

    public void setSavedView(DocumentsSavedview savedView) {
        this.savedView = savedView;
    }

}