package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailruleAssignTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailMailruleAssignTagRepository extends JpaRepository<PaperlessMailMailruleAssignTag, Long> {

}
