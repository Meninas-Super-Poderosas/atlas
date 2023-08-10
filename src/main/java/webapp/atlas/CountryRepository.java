package webapp.atlas;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.atlas.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{
}
