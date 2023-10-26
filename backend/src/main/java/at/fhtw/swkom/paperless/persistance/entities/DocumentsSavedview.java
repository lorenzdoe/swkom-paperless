package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "documents_savedview", indexes = {
        @Index(name = "documents_savedview_user_id_48baf272", columnList = "owner_id")
})
public class DocumentsSavedview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 128)
    @NotNull
    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @NotNull
    @Column(name = "show_on_dashboard", nullable = false)
    private Boolean showOnDashboard = false;

    @NotNull
    @Column(name = "show_in_sidebar", nullable = false)
    private Boolean showInSidebar = false;

    @Size(max = 128)
    @Column(name = "sort_field", length = 128)
    private String sortField;

    @NotNull
    @Column(name = "sort_reverse", nullable = false)
    private Boolean sortReverse = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @OneToMany(mappedBy = "savedView")
    private Set<DocumentsSavedviewfilterrule> documentsSavedviewfilterrules = new LinkedHashSet<>();

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

    public Boolean getShowOnDashboard() {
        return showOnDashboard;
    }

    public void setShowOnDashboard(Boolean showOnDashboard) {
        this.showOnDashboard = showOnDashboard;
    }

    public Boolean getShowInSidebar() {
        return showInSidebar;
    }

    public void setShowInSidebar(Boolean showInSidebar) {
        this.showInSidebar = showInSidebar;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public Boolean getSortReverse() {
        return sortReverse;
    }

    public void setSortReverse(Boolean sortReverse) {
        this.sortReverse = sortReverse;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

    public Set<DocumentsSavedviewfilterrule> getDocumentsSavedviewfilterrules() {
        return documentsSavedviewfilterrules;
    }

    public void setDocumentsSavedviewfilterrules(Set<DocumentsSavedviewfilterrule> documentsSavedviewfilterrules) {
        this.documentsSavedviewfilterrules = documentsSavedviewfilterrules;
    }

}