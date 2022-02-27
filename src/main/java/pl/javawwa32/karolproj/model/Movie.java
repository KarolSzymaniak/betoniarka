package pl.javawwa32.karolproj.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "movie_id")
    private long movieId;

    private String title;

    @Enumerated
    @Column(name = "genre")
    private Genre genre;

    private LocalDate releaseDate;


    private int numberOfCopies;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    private Set<MovieCopy> copies;

    private double avgScore;

    @Enumerated
    @Column(name = "movie_status")
    private MovieStatus movieStatus;



}