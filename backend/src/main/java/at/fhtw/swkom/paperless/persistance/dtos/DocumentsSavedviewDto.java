package at.fhtw.swkom.paperless.persistance.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedview}
 */
public class DocumentsSavedviewDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 128)
    private String name;
    @NotNull
    private Boolean showOnDashboard = false;
    @NotNull
    private Boolean showInSidebar = false;
    @Size(max = 128)
    private String sortField;
    @NotNull
    private Boolean sortReverse = false;
    private AuthUserDto owner;
    private Set<DocumentsSavedviewfilterruleDto> documentsSavedviewfilterrules = new LinkedHashSet<>();

    public DocumentsSavedviewDto() {
    }

    public DocumentsSavedviewDto(Integer id, String name, Boolean showOnDashboard, Boolean showInSidebar, String sortField, Boolean sortReverse, AuthUserDto owner, Set<DocumentsSavedviewfilterruleDto> documentsSavedviewfilterrules) {
        this.id = id;
        this.name = name;
        this.showOnDashboard = showOnDashboard;
        this.showInSidebar = showInSidebar;
        this.sortField = sortField;
        this.sortReverse = sortReverse;
        this.owner = owner;
        this.documentsSavedviewfilterrules = documentsSavedviewfilterrules;
    }

    public Integer getId() {
        return id;
    }

    public DocumentsSavedviewDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DocumentsSavedviewDto setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getShowOnDashboard() {
        return showOnDashboard;
    }

    public DocumentsSavedviewDto setShowOnDashboard(Boolean showOnDashboard) {
        this.showOnDashboard = showOnDashboard;
        return this;
    }

    public Boolean getShowInSidebar() {
        return showInSidebar;
    }

    public DocumentsSavedviewDto setShowInSidebar(Boolean showInSidebar) {
        this.showInSidebar = showInSidebar;
        return this;
    }

    public String getSortField() {
        return sortField;
    }

    public DocumentsSavedviewDto setSortField(String sortField) {
        this.sortField = sortField;
        return this;
    }

    public Boolean getSortReverse() {
        return sortReverse;
    }

    public DocumentsSavedviewDto setSortReverse(Boolean sortReverse) {
        this.sortReverse = sortReverse;
        return this;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    public DocumentsSavedviewDto setOwner(AuthUserDto owner) {
        this.owner = owner;
        return this;
    }

    public Set<DocumentsSavedviewfilterruleDto> getDocumentsSavedviewfilterrules() {
        return documentsSavedviewfilterrules;
    }

    public DocumentsSavedviewDto setDocumentsSavedviewfilterrules(Set<DocumentsSavedviewfilterruleDto> documentsSavedviewfilterrules) {
        this.documentsSavedviewfilterrules = documentsSavedviewfilterrules;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsSavedviewDto entity = (DocumentsSavedviewDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.showOnDashboard, entity.showOnDashboard) &&
                Objects.equals(this.showInSidebar, entity.showInSidebar) &&
                Objects.equals(this.sortField, entity.sortField) &&
                Objects.equals(this.sortReverse, entity.sortReverse) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.documentsSavedviewfilterrules, entity.documentsSavedviewfilterrules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, showOnDashboard, showInSidebar, sortField, sortReverse, owner, documentsSavedviewfilterrules);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "showOnDashboard = " + showOnDashboard + ", " +
                "showInSidebar = " + showInSidebar + ", " +
                "sortField = " + sortField + ", " +
                "sortReverse = " + sortReverse + ", " +
                "owner = " + owner + ", " +
                "documentsSavedviewfilterrules = " + documentsSavedviewfilterrules + ")";
    }
}