package webapp.atlas;

import jakarta.persistence.*;

@Entity
@Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String name;
    private int population;
    private String currencies;
    private String flag;
    private String capital;
    private String languages;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getPopulation(){
        return this.population;
    }
    public void setPopulation(int population){
        this.population = population;
    }
    public String getCurrencies(){
        return this.currencies;
    }
    public void setCurrencies(String currencies){
        this.currencies = currencies;
    }
    public String getFlag(){
        return this.flag;
    }
    public void setFlag(String name){
        this.flag = flag;
    }
    public String getCapital(){
        return this.capital;
    }
    public void setCapital(String capital){
        this.name = capital;
    }
    public String getLanguages(){
        return this.languages;
    }
    public void setLanguages(String languages){
        this.languages = languages;
    }
}
