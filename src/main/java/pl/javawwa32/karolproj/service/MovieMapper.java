package pl.javawwa32.karolproj.service;

import org.springframework.stereotype.Component;
import pl.javawwa32.karolproj.dto.MovieRequest;
import pl.javawwa32.karolproj.dto.MovieResponse;
import pl.javawwa32.karolproj.dto.UserRequest;
import pl.javawwa32.karolproj.dto.UserResponse;
import pl.javawwa32.karolproj.model.*;

import java.time.LocalDate;
import java.util.Set;

@Component
public class MovieMapper {

    public MovieResponse map(Movie movie){
        final MovieResponse movieResponse = MovieResponse
                .builder()
                .movieId(movie.getMovieId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .releaseDate(movie.getReleaseDate())
                .numberOfCopies(movie.getNumberOfCopies())
                .avgScore(movie.getAvgScore())
                .movieStatus(movie.getMovieStatus())

                .build();
        return movieResponse;
    }



    public Movie map(MovieRequest movieRequest){
        final Movie movie = Movie
                .builder()
                .title(movieRequest.getTitle())
                .genre(movieRequest.getGenre())
                .releaseDate(movieRequest.getReleaseDate())
                .numberOfCopies(movieRequest.getNumberOfCopies())
                .avgScore(movieRequest.getAvgScore())
                .movieStatus(movieRequest.getMovieStatus())
                .build();

        return movie;
    }
}
