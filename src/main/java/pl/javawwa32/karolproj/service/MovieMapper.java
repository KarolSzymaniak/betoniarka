package pl.javawwa32.karolproj.service;
import org.springframework.stereotype.Component;
import pl.javawwa32.karolproj.dto.*;
import pl.javawwa32.karolproj.model.Movie;




@Component
public class MovieMapper {


    public static MovieMainPageDto mapForMainPage(Movie movie) {
        return MovieMainPageDto.builder()
                .title(movie.getTitle())
                .description(movie.getDescription())
                .movieStatus(movie.getMovieStatus())
                .genre(movie.getGenre())
                .avgScore(movie.getAvgScore())
                .releaseDate(movie.getReleaseDate())
                .build();
    }


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



    public MovieMainPageDto movieMainPageDto(Movie movie){
        final MovieMainPageDto movieResponse = MovieMainPageDto
                .builder()
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .avgScore(movie.getAvgScore())
                .description(movie.getDescription())
                .movieStatus(movie.getMovieStatus())
                .releaseDate(movie.getReleaseDate())
                .numberOfCopies(movie.getNumberOfCopies())
                .build();
        return movieResponse;
    }
}
