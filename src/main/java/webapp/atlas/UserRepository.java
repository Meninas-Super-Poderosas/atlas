package webapp.atlas;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.atlas.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
