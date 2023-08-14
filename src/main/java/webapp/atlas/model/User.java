package webapp.atlas.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name="users")
public @Data @NonNull class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @NonNull
    private String email;

    @Column(nullable = false)
    private String password;

    public User() {

    }
}