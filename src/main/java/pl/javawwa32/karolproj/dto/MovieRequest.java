package pl.javawwa32.karolproj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import pl.javawwa32.karolproj.model.MovieCopy;
import pl.javawwa32.karolproj.model.Genre;
import pl.javawwa32.karolproj.model.MovieStatus;

import java.time.LocalDate;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieRequest {

    private long movieId;

    private String title;

    private Genre genre;

    private LocalDate releaseDate;

    private int numberOfCopies;

    private Set<MovieCopy> copies;

    private double avgScore;

    private MovieStatus movieStatus;
}

