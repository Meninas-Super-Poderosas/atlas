package webapp.atlas.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import webapp.atlas.model.Country;
import webapp.atlas.service.CountryService;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    @Operation(summary = "Create Country", description = "Accepts request/JSON. Add a new country and store it in the database.")
    public Country createCountry(@RequestBody Country country) {
        return countryService.createCountry(country);
    }

    // Delete country by name
    @DeleteMapping("/{id}")
    @Operation(summary = "Specify one country and then delete it")
    @Parameter(name = "id", required = true, description = "ID of the country that will be deleted.")
    @Schema(accessMode = READ_ONLY)
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }


    @GetMapping
    @Operation(summary = "Get all countries.", description = "returns JSON with all countries.")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @Operation(summary = "Update Country", description = "Accepts request/JSON. Add a new country and store it in the database.")
    @Parameter(name = "id", required = true, description = "Id of the country that will be updated")
    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country){
        return countryService.updateCountry(id, country);
    }

    @PostMapping("/create-all-countries")
    public List<Country> createAllcountries() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                "https://restcountries.com/v3.1/name/Brazil?fields=name,flags,capital,population,currencies,languages",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {}
        );
        List<Map<String, Object>> countryDataList = response.getBody();

        List<Country> createdCountries = new ArrayList<>();

        assert countryDataList != null;
        for (Map<String, Object> countryData : countryDataList) {
            Map<String, Object> flags = (Map<String, Object>) countryData.get("flags");
            String flagUrl = (String) flags.get("png");

            String name = (String) ((Map<String, Object>) countryData.get("name")).get("common");
            Long population = Long.valueOf((Integer) countryData.get("population"));
            String currency = (String) ((Map<String, Object>) ((Map<String, Object>) countryData.get("currencies")).values().iterator().next()).get("name");
            String language = (String) ((Map<String, Object>) countryData.get("languages")).values().iterator().next();
            String capital = ((List<String>) countryData.get("capital")).get(0);

            Country country = new Country();
            country.setName(name);
            country.setPopulation(population);
            country.setCurrencies(currency);
            country.setLanguages(language);
            country.setCapital(capital);
            country.setFlag(flagUrl);

            createdCountries.add(countryService.createCountry(country));

        }

        return createdCountries;
    }
}
