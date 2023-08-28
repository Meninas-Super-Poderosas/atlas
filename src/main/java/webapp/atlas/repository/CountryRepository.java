package webapp.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.atlas.model.Country;
import webapp.atlas.model.User;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long>{
    Optional<Country> findByName(String name);
    List<Country> findAllByOrderByVotesDesc();

}
