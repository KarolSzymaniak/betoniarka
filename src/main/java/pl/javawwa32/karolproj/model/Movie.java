package pl.javawwa32.karolproj.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "genre")
    private String genere;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "movie")
    private Set<MovieCopy> copies;

    private int avgScore;
    private int noOfCopies;

}
