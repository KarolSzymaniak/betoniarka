package pl.javawwa32.karolproj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javawwa32.karolproj.dto.MovieRequest;
import pl.javawwa32.karolproj.dto.MovieResponse;
import pl.javawwa32.karolproj.service.MovieService;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(path = "/api/movie")
    public ResponseEntity<MovieResponse> findByTitle(@RequestParam String title){
        final MovieResponse movie = movieService.findResponseByTitle(title);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Example_header", "dummy_value");
        return new ResponseEntity(movie, httpHeaders, HttpStatus.ACCEPTED);
    }


    @PostMapping(path = "/api/movie")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createMovie(@RequestBody MovieRequest movie){
        movieService.save(movie);
    }
    
}
