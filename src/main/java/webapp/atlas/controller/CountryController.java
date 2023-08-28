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
import java.util.concurrent.TimeUnit;

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

//    @Operation(summary = "Update Country", description = "Accepts request/JSON. Add a new country and store it in the database.")
//    @Parameter(name = "id", required = true, description = "Id of the country that will be updated")
//    @PutMapping("/{id}")
//    public Country updateCountry(@PathVariable Long id, @RequestBody Country country){
//        return countryService.updateCountry(id, country);
//    }

//
//    private List<String> getAllCountryNames() {
//        List<String> countryNames = Arrays.asList(
//                "Marshall Islands", "Nepal", "Ecuador", "Gabon", "Saudi Arabia", "Dominican Republic", "Saint Pierre and Miquelon",
//                "Faroe Islands", "Kiribati", "Vanuatu", "Hungary", "South Georgia", "Yemen", "French Guiana", "Seychelles", "American Samoa",
//                "Cyprus", "Libya", "Israel", "Vietnam", "Slovenia", "Iran", "Namibia", "Greece", "Lebanon", "Malaysia", "Mongolia", "Åland Islands", "Georgia",
//                "Tajikistan", "Albania", "Dominica", "Turkmenistan", "Colombia", "Venezuela", "Guinea", "South Sudan", "Ukraine",
//                "Slovakia", "Italy", "Falkland Islands", "Guadeloupe", "Honduras", "Montenegro", "Estonia", "Brazil", "Mauritius", "Thailand", "Bolivia",
//                "Sweden", "Guernsey", "Zambia", "Eritrea", "Kazakhstan", "Morocco", "Jordan", "Myanmar", "San Marino", "Palau", "Mayotte", "United States Minor Outlying Islands",
//                "Czechia", "Jamaica", "Kyrgyzstan", "Sudan", "São Tomé and Príncipe", "Gibraltar",
//                "Niger", "Caribbean Netherlands", "Australia", "Luxembourg", "Sint Maarten", "Lesotho", "Poland", "Guam", "Japan", "Liberia", "Cape Verde",
//                "Isle of Man", "Burundi", "Papua New Guinea", "Uganda", "Afghanistan", "Wallis and Futuna", "Central African Republic", "Vatican City", "France", "United States", "Timor-Leste", "Botswana"
//        );
//        return countryNames;
//    }
////MACAU "Heard Island and McDonald Islands"
//    @PostMapping("/create-all-countries")
//    public List<Country> createAllcountries() throws InterruptedException {
//        RestTemplate restTemplate = new RestTemplate();
//        List<String> countryNames = getAllCountryNames();
//        List<Country> createdCountries = new ArrayList<>();
//
//        for (String countryName : countryNames) {
//            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
//                    "https://restcountries.com/v3.1/name/" + countryName + "?fields=name,flags,capital,population,currencies,languages",
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<List<Map<String, Object>>>() {}
//            );
//
//            List<Map<String, Object>> countryDataList = response.getBody();
//            if (countryDataList != null && !countryDataList.isEmpty()) {
//                Map<String, Object> countryData = countryDataList.get(0);
//                Map<String, Object> flags = (Map<String, Object>) countryData.get("flags");
//                String flagUrl = (String) flags.get("png");
//
//                String name = (String) ((Map<String, Object>) countryData.get("name")).get("common");
//                Long population = Long.valueOf((Integer) countryData.get("population"));
//                String currency = (String) ((Map<String, Object>) ((Map<String, Object>) countryData.get("currencies")).values().iterator().next()).get("name");
//                String language = (String) ((Map<String, Object>) countryData.get("languages")).values().iterator().next();
//                String capital = ((List<String>) countryData.get("capital")).get(0);
//
//                Country country = new Country();
//                country.setName(name);
//                country.setPopulation(population);
//                country.setCurrencies(currency);
//                country.setLanguages(language);
//                country.setCapital(capital);
//                country.setFlag(flagUrl);
//
//                createdCountries.add(countryService.createCountry(country));
//                Thread.sleep(100);
//
//            }
//        }
//
//        return createdCountries;
//    }
//
//    private List<String> getAllCountryNames2() {
//        List<String> countryNames2 = Arrays.asList(
//                "South Africa", "Svalbard and Jan Mayen", "Samoa", "Gambia", "Saint Kitts and Nevis", "Monaco", "Aruba", "Guinea-Bissau", "North Korea", "Paraguay", "Bermuda", "Republic of the Congo",
//                "United States Virgin Islands", "Antigua and Barbuda",
//                "United Kingdom", "Mozambique", "Martinique", "British Virgin Islands", "Somalia", "Montserrat", "Northern Mariana Islands", "Singapore", "Turks and Caicos Islands",
//                "Nicaragua", "Norfolk Island", "Saint Vincent and the Grenadines", "Peru", "Mexico", "Equatorial Guinea", "Bosnia and Herzegovina", "Bahrain", "Barbados", "Uzbekistan", "Réunion", "China", "Malawi", "Zimbabwe", "Spain",
//                "Kenya", "Pakistan", "Christmas Island", "Fiji", "Eswatini", "Jersey", "Taiwan", "Sri Lanka", "Belarus", "United Arab Emirates", "Curaçao", "Costa Rica", "Angola", "Uruguay", "DR Congo", "Kuwait", "Turkey", "Mauritania",
//                "Tuvalu", "Panama", "Egypt", "Saint Lucia", "Azerbaijan", "Rwanda", "Senegal", "India", "Iceland", "Suriname", "Bulgaria", "Micronesia", "Kosovo", "Sierra Leone",
//                "Tunisia", "Cuba", "Trinidad and Tobago", "Comoros", "Nauru", "Saint Helena, Ascension and Tristan da Cunha", "Romania"
//        );
//        return countryNames2;
//    }
//
//    @PostMapping("/create-all-countries2")
//    public List<Country> createAllcountries2() throws InterruptedException {
//        RestTemplate restTemplate2 = new RestTemplate();
//        List<String> countryNames2 = getAllCountryNames2();
//        List<Country> createdCountries2 = new ArrayList<>();
//
//        for (String countryName : countryNames2) {
//            ResponseEntity<List<Map<String, Object>>> response = restTemplate2.exchange(
//                    "https://restcountries.com/v3.1/name/" + countryName + "?fields=name,flags,capital,population,currencies,languages",
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<List<Map<String, Object>>>() {}
//            );
//
//            List<Map<String, Object>> countryDataList = response.getBody();
//            if (countryDataList != null && !countryDataList.isEmpty()) {
//                Map<String, Object> countryData = countryDataList.get(0);
//                Map<String, Object> flags = (Map<String, Object>) countryData.get("flags");
//                String flagUrl = (String) flags.get("png");
//
//                String name = (String) ((Map<String, Object>) countryData.get("name")).get("common");
//                Long population = Long.valueOf((Integer) countryData.get("population"));
//                String currency = (String) ((Map<String, Object>) ((Map<String, Object>) countryData.get("currencies")).values().iterator().next()).get("name");
//                String language = (String) ((Map<String, Object>) countryData.get("languages")).values().iterator().next();
//                String capital = ((List<String>) countryData.get("capital")).get(0);
//
//                Country country = new Country();
//                country.setName(name);
//                country.setPopulation(population);
//                country.setCurrencies(currency);
//                country.setLanguages(language);
//                country.setCapital(capital);
//                country.setFlag(flagUrl);
//
//                createdCountries2.add(countryService.createCountry(country));
//                Thread.sleep(100);
//            }
//        }
//
//        return createdCountries2;
//    }


}
