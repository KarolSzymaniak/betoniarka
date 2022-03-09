package pl.javawwa32.karolproj.dto;

import lombok.*;
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
public class MovieMainPageDto {



    private String title;

    private Genre genre;

    private String description;

    private double avgScore;

    private LocalDate releaseDate;

    private int numberOfCopies;


    private MovieStatus movieStatus;

}