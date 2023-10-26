package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "paperless_mail_mailrule_assign_tags", indexes = {
        @Index(name = "paperless_mail_mailrule__mailrule_id_tag_id_0960fdac_uniq", columnList = "mailrule_id, tag_id", unique = true),
        @Index(name = "paperless_mail_mailrule_assign_tags_mailrule_id_80d0b16c", columnList = "mailrule_id"),
        @Index(name = "paperless_mail_mailrule_assign_tags_tag_id_4d0ac8d5", columnList = "tag_id")
})
public class PaperlessMailMailruleAssignTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mailrule_id", nullable = false)
    private PaperlessMailMailrule mailrule;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_id", nullable = false)
    private DocumentsTag tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaperlessMailMailrule getMailrule() {
        return mailrule;
    }

    public void setMailrule(PaperlessMailMailrule mailrule) {
        this.mailrule = mailrule;
    }

    public DocumentsTag getTag() {
        return tag;
    }

    public void setTag(DocumentsTag tag) {
        this.tag = tag;
    }

}