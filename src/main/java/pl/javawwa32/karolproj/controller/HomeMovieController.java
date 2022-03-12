package pl.javawwa32.karolproj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.javawwa32.karolproj.dto.MovieMainPageDto;
import pl.javawwa32.karolproj.model.Genre;
import pl.javawwa32.karolproj.service.MainPageMoviesService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeMovieController {

   private final MainPageMoviesService mainPageMoviesService;


   //wyświetlanie  fimów po średniej ocenie
    @GetMapping("/api/avgRate")
    public List<MovieMainPageDto> getByAvgRate(@RequestParam(required = false) Genre genre) {
        return this.mainPageMoviesService.getByAvgRate(genre);
    }

    //wyświetlanie fimów po dacie premiery
    @GetMapping("/api/premiereDate")
    public List<MovieMainPageDto> getByPremiereDate(@RequestParam (required = false) Genre genre) {
        return this.mainPageMoviesService.getByPremiereDate(genre);
    }

}