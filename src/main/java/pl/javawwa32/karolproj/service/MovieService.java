package pl.javawwa32.karolproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javawwa32.karolproj.dto.MovieRequest;
import pl.javawwa32.karolproj.dto.MovieResponse;
import pl.javawwa32.karolproj.dto.UserRequest;
import pl.javawwa32.karolproj.dto.UserResponse;
import pl.javawwa32.karolproj.model.Movie;
import pl.javawwa32.karolproj.model.User;
import pl.javawwa32.karolproj.repository.MoviesRepository;
import pl.javawwa32.karolproj.repository.UsersRepository;

@Service
public class MovieService {


    private final MoviesRepository moviesRepository;
    private final MovieMapper mapper;

    @Autowired
    public MovieService(MoviesRepository moviesRepository, MovieMapper mapper) {
        this.moviesRepository = moviesRepository;
        this.mapper = mapper;
    }


    public void save(MovieRequest movieRequest){
        Movie movie = mapper.map(movieRequest);
        moviesRepository.save(movie);
    }



    public Movie findByTitle(String title){
        return moviesRepository.findByTitle(title);
    }

    public MovieResponse findResponseByTitle(String title){
        final Movie movie = findByTitle(title);
        return mapper.map(movie);
    }



    public Movie findByAvgScore(double avgScore){
        return moviesRepository.findByAvgScore(avgScore);
    }

    public MovieResponse findMoviesForMainPage(double avgScore){
        final Movie movie = findByAvgScore(avgScore);
        return mapper.movieMainPageDto(movie);
    }

}
