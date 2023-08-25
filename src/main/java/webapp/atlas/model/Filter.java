package webapp.atlas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Entity
@Getter
@Setter
@Table(name="filters")
public @Data class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Filter ID", accessMode = READ_ONLY)
    private Long userId;
    private String currency;
    private String region;
    private String language;

}
