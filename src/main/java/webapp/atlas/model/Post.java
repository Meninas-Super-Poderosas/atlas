package webapp.atlas.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="posts")
public @Data class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name= "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

    //Referenciar user
    private String title;

    private String body;

    private int likes;



}
