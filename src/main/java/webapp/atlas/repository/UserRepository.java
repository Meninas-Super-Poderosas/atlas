package webapp.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.atlas.model.Role;
import webapp.atlas.model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    Boolean existsByEmail(String email);

    Optional<User> findByNameOrEmail(String name, String email);
    List<User> findByRolesContaining(Role role);


}
