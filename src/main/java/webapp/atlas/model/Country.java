package webapp.atlas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Entity
@Setter
@Getter
@Table(name="countries")
public @Data class Country {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    @Schema(description = "Country ID", accessMode = READ_ONLY)
    private long id;
//
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    @JsonPropertyOrder({
//            "name",
//            "population",
//            "currencies",
//            "flag",
//            "languages"
//    })
//
//    //Referenciar post
//    @OneToMany(mappedBy = "country")
//    private Set<Post> posts;


    @Schema(description = "Country name", type = "String")
    private String name;

    @Schema(description = "Total population", type = "Integer")
    private long population;

    @Schema(description = "Main currency used in the country", type = "Integer")
    private String currencies;

    @Schema(description = "Country's flag emoji", type = "String")
    private String flag;

    @Schema(description = "Country's capital", type = "String")
    private String capital;

    @Schema(description = "Most spoken language", type = "String")
    private String languages;



}
