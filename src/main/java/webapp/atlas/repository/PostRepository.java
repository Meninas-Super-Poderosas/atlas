package webapp.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.atlas.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
