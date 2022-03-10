package pl.javawwa32.karolproj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.javawwa32.karolproj.dto.MovieMainPageDto;
import pl.javawwa32.karolproj.model.Genre;
import pl.javawwa32.karolproj.service.ShowMovies;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeMovieController {

   private final ShowMovies showMovies;


    @GetMapping("/api/avgRate")
    public List<MovieMainPageDto> getByAvgRate(@RequestParam(required = false) Genre genre) {
        return this.showMovies.getByAvgRate(genre);
    }

    @GetMapping("/api/premiereDate")
    public List<MovieMainPageDto> getByPremiereDate(@RequestParam (required = false) Genre genre) {
        return this.showMovies.getByPremiereDate(genre);
    }

}