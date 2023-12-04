package at.fhtw.swkom.paperless.persistance.repositories.DB;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsPaperlesstask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DocumentsPaperlesstaskRepository extends JpaRepository<DocumentsPaperlesstask, Long> {

}
