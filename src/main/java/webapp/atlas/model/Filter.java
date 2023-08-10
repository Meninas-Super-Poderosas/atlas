package webapp.atlas.model;

import jakarta.persistence.*;

@Table(name="filters")
@Entity
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long minPopulation;
    private long maxPopulation;
    private String currencies;
    private String language;
    private String capital;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMinPopulation() {
        return minPopulation;
    }

    public void setMinPopulation(long minPopulation) {
        this.minPopulation = minPopulation;
    }

    public long getMaxPopulation() {
        return maxPopulation;
    }

    public void setMaxPopulation(long maxPopulation) {
        this.maxPopulation = maxPopulation;
    }

    public String getCurrencies() {
        return currencies;
    }

    public void setCurrencies(String currencies) {
        this.currencies = currencies;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
