package webapp.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.atlas.model.Role;
import webapp.atlas.model.User;
import java.util.Map;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
