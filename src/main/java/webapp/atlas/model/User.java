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

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    public User() {

    }
}