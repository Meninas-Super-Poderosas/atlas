    package webapp.atlas.model;

    import io.swagger.v3.oas.annotations.media.Schema;
    import jakarta.persistence.*;
    import lombok.Data;
    import lombok.Getter;
    import lombok.Setter;
    import org.hibernate.annotations.CreationTimestamp;

    import java.time.LocalDateTime;

    import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

    @Entity
    @Getter
    @Setter
    @Table(name="filters")
    public @Data class Filter {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Schema(description = "Filter ID", accessMode = READ_ONLY)
        private Long id;
        private String filterType;

        @CreationTimestamp
        private LocalDateTime createdAt;
    }
