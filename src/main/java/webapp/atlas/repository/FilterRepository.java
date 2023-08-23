package webapp.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.atlas.model.Filter;

public interface FilterRepository extends JpaRepository<Filter, Long> {

}
