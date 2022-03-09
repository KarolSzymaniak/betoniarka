package pl.javawwa32.karolproj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.javawwa32.karolproj.model.Genre;
import pl.javawwa32.karolproj.model.MovieStatus;
import pl.javawwa32.karolproj.model.Rating;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieDto {

    private Long movieId;
    private String title;
    private String director;
    private Genre genre;
    private String description;
    private MovieStatus movieStatus;
    private Genre movieGenre;
    private LocalDateTime createdAt;
    private double avgRate;
    private LocalDate releaseDate;
    private int numberOfCopies;;
    private List<Rating> rateList;

}