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
@Builder
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

    @Column(name = "description")
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "number_of_copies")
    private int numberOfCopies;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    private Set<MovieCopy> copies;

    private double avgScore;

    @Enumerated
    @Column(name = "movie_status")
    private MovieStatus movieStatus;

    public Movie(String title, Genre genre, String description, LocalDate releaseDate, int numberOfCopies, double avgScore, MovieStatus movieStatus) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.releaseDate = releaseDate;
        this.numberOfCopies = numberOfCopies;
        this.avgScore = avgScore;
        this.movieStatus = movieStatus;
    }
}