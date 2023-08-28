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
    //Referenciar post


    @Schema(description = "count the votes" )
    private int votes;

    @Schema(description = "flag url" )
    private String flagUrl;

    @Schema(description = "Country name" )
    private String name;


}
