package webapp.atlas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;


@Entity
@Table(name="posts")
public @Data class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Post ID", accessMode = READ_ONLY)
    private long id;

    //Referenciar pais
//    @ManyToOne
//    @JoinColumn(name= "country_id")
//    @Schema(description = "Country id")
//    private Country country;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Schema(description = "User id")
    private User user;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    @Schema(description = "Post's title", nullable = true, type = "String")
    private String title;

    @Schema(description = "Post's description", nullable = true, type = "Long String")
    private String description;

    @Column(columnDefinition = "TEXT", length = 512)
    @Schema(description = "Post's Content", nullable = true, type = "String")
    private String body;

    @Schema(description = "Total post's likes", nullable = true, type = "Integer")
    private int likes;

}
