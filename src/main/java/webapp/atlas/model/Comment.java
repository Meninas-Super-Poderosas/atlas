package webapp.atlas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;


@Entity
@Table(name="commments")

public @Data class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Comment ID", accessMode = READ_ONLY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    @Schema(description = "User Id")
    private User user;


    @ManyToOne
    @JoinColumn(name="post_id")
    @Schema(description = "Post Id")
    private Post post;

    private String body;
}
