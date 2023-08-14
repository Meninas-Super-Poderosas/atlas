package webapp.atlas.model;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Entity
@Table(name="users")
public @Data @NonNull class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "User ID", accessMode = READ_ONLY)
    private Long id;

    @NonNull
    @Schema(description = "Username")
    private String name;

    @NonNull
    @Schema(description = "User's E-mail", example = "example@gmail.com")
    private String email;

    @NonNull
    @Schema(description = "User's password", minLength = 8, maxLength = 24)
    private String password;

    public User() {

    }
}