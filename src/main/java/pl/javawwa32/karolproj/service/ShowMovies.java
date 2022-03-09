package pl.javawwa32.karolproj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javawwa32.karolproj.dto.MovieMainPageDto;
import pl.javawwa32.karolproj.model.Genre;
import pl.javawwa32.karolproj.model.Movie;
import pl.javawwa32.karolproj.repository.MoviesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ShowMovies {
    private final MoviesRepository moviesRepository;

    public List<MovieMainPageDto> getByAvgRate(Genre genre) {

        List<Movie> movieList = (moviesRepository.findByOrderByAvgScoreDesc());
        if (genre != null) {
            movieList = filterByGenre(movieList, genre);
        }
        List<MovieMainPageDto> movieDtos = new ArrayList<>();
        for (Movie movie : movieList) {
            movieDtos.add(MovieMapper.mapForMainPage(movie));
        }
        return movieDtos;
    }

    private List<Movie> filterByGenre(List<Movie> list, Genre genre) {

        list.removeIf(movie -> !movie.getGenre().equals(genre));
        return list;
    }
}
