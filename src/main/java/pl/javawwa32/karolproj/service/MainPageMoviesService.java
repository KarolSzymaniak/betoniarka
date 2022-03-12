package pl.javawwa32.karolproj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
public class MainPageMoviesService {
    private final MoviesRepository moviesRepository;

//    public List<MovieMainPageDto> getByAlphabeticalOrder(Genre genre) {
//
//        List<Movie> movieList = (moviesRepository.findByMovieByTitle());
//        if (genre != null) {
//            movieList = filterByGenre(movieList, genre);
//        }
//        List<MovieMainPageDto> movieDtos = new ArrayList<>();
//        for (Movie movie : movieList) {
//            movieDtos.add(MovieMapper.mapForMainPage(movie));
//        }
//        return movieDtos;
//    }



    //do wyszukiwania wszystkich filmów po ocenie
//    public List<MovieMainPageDto> getByAvgRate(Genre genre) {
//
//        List<Movie> movieList = (moviesRepository.findByOrderByAvgScoreDesc());
//        if (genre != null) {
//            movieList = filterByGenre(movieList, genre);
//        }
//        List<MovieMainPageDto> movieDtos = new ArrayList<>();
//        for (Movie movie : movieList) {
//            movieDtos.add(MovieMapper.mapForMainPage(movie));
//        }
//        return movieDtos;
//    }

    public List<MovieMainPageDto> getByAvgRate(Genre genre) {

        List<Movie> moviesList = (moviesRepository.findByOrderByAvgScoreDesc(PageRequest.of(0,3)));
        if (genre != null) {
            moviesList = filterByGenre(moviesList, genre);
        }
        List<MovieMainPageDto> movieDtos = new ArrayList<>();
        for (Movie movie : moviesList) {
            movieDtos.add(MovieMapper.mapForMainPage(movie));
        }
        return movieDtos;
    }


    private List<Movie> filterByGenre(List<Movie> list, Genre genre) {

        list.removeIf(movie -> !movie.getGenre().equals(genre));
        return list;
    }




    public List<MovieMainPageDto> getByPremiereDate(Genre genre) {

        List<Movie> moviesList = (moviesRepository.findByOrderByReleaseDate());
        if (genre != null) {
            moviesList = filterByGenre(moviesList, genre);
        }
        List<MovieMainPageDto> movieDto = new ArrayList<>();
        for (Movie movie : moviesList) {
            movieDto.add(MovieMapper.mapForMainPage(movie));
        }
        return movieDto;
    }
}
