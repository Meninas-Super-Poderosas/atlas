package webapp.atlas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="countries")
public @Data class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String name;
    private int population;
    private String currencies;
    private String flag;
    private String capital;
    private String languages;


}
