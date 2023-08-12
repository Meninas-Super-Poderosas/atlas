package webapp.atlas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webapp.atlas.model.Country;
import webapp.atlas.service.CountryService;


import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryService.createCountry(country);
    }

    // Delete country by name
    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService. deleteCountry(id);
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country){
        return countryService.updateCountry(id, country);
    }
}
