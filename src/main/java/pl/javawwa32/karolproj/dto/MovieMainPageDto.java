package pl.javawwa32.karolproj.dto;

import lombok.*;
import pl.javawwa32.karolproj.model.Genre;
import pl.javawwa32.karolproj.model.MovieCopy;
import pl.javawwa32.karolproj.model.MovieStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieMainPageDto {

    private long movieId;

    private String title;

    private Genre genre;

    private String description;


    private LocalDate releaseDate;

    private int numberOfCopies;

    private Set<MovieCopy> copies;

    private double avgScore;

    private MovieStatus movieStatus;
}