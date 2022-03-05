package pl.javawwa32.karolproj.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "rating_id")
    public long ratingId;

    //mapowanie w opcji nr 2 z notatki
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //mapowanie w opcji nr 2 z notatki
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private double score;

    private String text;

}
