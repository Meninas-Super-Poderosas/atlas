package webapp.atlas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.atlas.repository.CountryRepository;
import webapp.atlas.model.Country;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public List<Country> getAllCountries() {
       return countryRepository.findAll();
    }

    public Optional<Country> getCountryById(long id){
        return countryRepository.findById(id);
    }

    public Country updateCountry(long id, Country country){
        countryRepository.deleteById(id);
        country.setName(country.getName());
        return countryRepository.save(country);
    }

    public void deleteCountry(long id) {
        countryRepository.deleteById(id);
    }
}
