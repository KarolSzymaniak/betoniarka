package pl.javawwa32.karolproj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javawwa32.karolproj.dto.MovieMainPageDto;
import pl.javawwa32.karolproj.repository.MoviesRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReadMovieController {

    @Autowired
    private final MoviesRepository moviesRepository;

    public MovieMainPageDto readById(Long id){
        return MovieMapper.mapForMainPage(moviesRepository.findById(id).get());
    }

}