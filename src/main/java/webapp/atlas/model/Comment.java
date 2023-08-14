package webapp.atlas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import webapp.atlas.model.Post;
import webapp.atlas.model.User;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;


@Entity
@Table(name="commments")

public @Data class Comment {

    @Schema(description = "Comment ID", accessMode = READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "User Id")
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @Schema(description = "Post Id")
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    private String body;
}
