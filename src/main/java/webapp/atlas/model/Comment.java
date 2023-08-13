package webapp.atlas.model;

import jakarta.persistence.*;
import lombok.Data;
import webapp.atlas.model.Post;
import webapp.atlas.model.User;


@Entity
@Table(name="commments")

public @Data class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    private String body;
}
