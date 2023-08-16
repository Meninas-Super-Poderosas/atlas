package webapp.atlas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Entity
@Table(name="countries")
public @Data class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Country ID", accessMode = READ_ONLY)
    private long id;

    @Schema(description = "Country name", type = "String")
    private String name;

    @Schema(description = "Total population", type = "Integer")
    private int population;

    @Schema(description = "Main currency used in the country", type = "Integer")
    private String currencies;

    @Schema(description = "Country's flag emoji", type = "String")
    private String flag;

    @Schema(description = "Country's capital", type = "String")
    private String capital;

    @Schema(description = "Most spoken language", type = "String")
    private String languages;


}
