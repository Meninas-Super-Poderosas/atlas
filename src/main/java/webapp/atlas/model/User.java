package webapp.atlas.model;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public @Data @NonNull class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "User ID", accessMode = READ_ONLY)
    private Long id;

    @NonNull
    @Schema(description = "Username")
    @Column(nullable = false, unique = true)
    private String name;

    @NonNull
    @Schema(description = "User's E-mail", example = "example@gmail.com")
    @Column(nullable = false, unique = true)
    private String email;

    @NonNull
    @Schema(description = "User's password", minLength = 8, maxLength = 24)
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;
}