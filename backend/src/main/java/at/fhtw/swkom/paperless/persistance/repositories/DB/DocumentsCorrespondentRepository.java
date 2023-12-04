package at.fhtw.swkom.paperless.persistance.repositories.DB;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsCorrespondent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DocumentsCorrespondentRepository extends JpaRepository<DocumentsCorrespondent, Long> {

}
