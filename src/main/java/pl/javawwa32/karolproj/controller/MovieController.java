package pl.javawwa32.karolproj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javawwa32.karolproj.dto.MovieMainPageDto;
import pl.javawwa32.karolproj.dto.MovieRequest;
import pl.javawwa32.karolproj.dto.MovieResponse;
import pl.javawwa32.karolproj.service.MovieService;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;


//    @GetMapping(path = "/api/movie")
//    public ResponseEntity<MovieResponse> findByTitle(@RequestParam String title){
//        final MovieResponse movie = movieService.findResponseByTitle(title);
//        final HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Example_header", "dummy_value");
//        return new ResponseEntity(movie, httpHeaders, HttpStatus.ACCEPTED);
//    }


    //wyłączone przez optional
//    @GetMapping(path = "/api/movie")
//    public ResponseEntity<MovieResponse> findByTitle(@RequestParam String title){
//        final Movie movie = movieService.findByTitle(title);
//        final HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Example_header", "dummy_value");
//        return new ResponseEntity(movie, httpHeaders, HttpStatus.ACCEPTED);
//    }


    @GetMapping(path = "/api/movie")
    public ResponseEntity<MovieMainPageDto> findByTitle(@RequestParam String title){
        final MovieMainPageDto movie = movieService.findResponseByTitle(title);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Example_header", "dummy_value");
        return new ResponseEntity(movie, httpHeaders, HttpStatus.ACCEPTED);
    }

//
//    @GetMapping("/api/getMovieById/{id}")
//    public MovieDto getById(@PathVariable int id){
//        return this.readMovieFromCentralStore.readById(id);
//    }

//    @GetMapping("/api/getMovieId/{id}")
//    public MovieDto getById(@PathVariable long id){
//        return this.readMovieFromStoreService.readById(id);
//    }
//
//    @GetMapping("/api/getMovieTitle")
//    public MovieDto getByTitle(@RequestParam String title){
//        return this.readMovieFromStoreService.readByTitle(title);
//    }
//



    @PostMapping(path = "/api/movie")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createMovie(@RequestBody MovieRequest movie){
        movieService.save(movie);
    }


//    @GetMapping(path = "/api/movieMain")
//    public ResponseEntity<MovieResponse> findByAvgScore(@RequestParam double avgScore){
//        final MovieResponse movie = movieService.findMoviesForMainPage(avgScore);
//        final HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Example_header", "dummy_value");
//        return new ResponseEntity(movie, httpHeaders, HttpStatus.ACCEPTED);
//    }

    
}
