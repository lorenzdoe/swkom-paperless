package at.fhtw.swkom.paperless.persistance.repositories.DB;

import at.fhtw.swkom.paperless.persistance.entities.AuthGroupPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthGroupPermissionRepository extends JpaRepository<AuthGroupPermission, Long> {

}
