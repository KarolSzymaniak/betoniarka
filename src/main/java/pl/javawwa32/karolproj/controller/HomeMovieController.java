package pl.javawwa32.karolproj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.javawwa32.karolproj.dto.MovieMainPageDto;
import pl.javawwa32.karolproj.model.Genre;
import pl.javawwa32.karolproj.service.ShowMovies;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeMovieController {

   private final ShowMovies showMovies;
//
//    @GetMapping("/api/titles")
//    public List<MovieMainPageDto> getByTitleAlphabetical(@RequestParam(required = false) MovieGenre genre) {
//        return this.showMovies.getByAlphabeticalOrder(genre);
//    }
//    @GetMapping("/api/premiereDate")
//    public List<MovieMainPageDto> getByPremDate(@RequestParam (required = false)MovieGenre genre) {
//        return this.showMovies.getByPremiereDate(genre);
//    }
//    @GetMapping("/api/creationDate")
//    public List<MovieMainPageDto> getByCreationDate(@RequestParam(required = false)MovieGenre genre) {
//        return this.showMovies.getByCreationDate(genre);
//    }
    @GetMapping("/api/avgRate")
    public List<MovieMainPageDto> getByAvgRate(@RequestParam(required = false) Genre genre) {
        return this.showMovies.getByAvgRate(genre);
    }
}