package pl.javawwa32.karolproj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javawwa32.karolproj.dto.MovieMainPageDto;
import pl.javawwa32.karolproj.dto.MovieRequest;
import pl.javawwa32.karolproj.model.Genre;
import pl.javawwa32.karolproj.service.MovieService;
import pl.javawwa32.karolproj.service.ReadMovie;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private  final ReadMovie readMovie;




    //wyłączone przez optional
//    @GetMapping(path = "/api/movie")
//    public ResponseEntity<MovieResponse> findByTitle(@RequestParam String title){
//        final Movie movie = movieService.findByTitle(title);
//        final HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Example_header", "dummy_value");
//        return new ResponseEntity(movie, httpHeaders, HttpStatus.ACCEPTED);
//    }


    //szukanie fimów po nazwie
    @GetMapping(path = "/api/movie")
    public ResponseEntity<MovieMainPageDto> findByTitle(@RequestParam String title){
        final MovieMainPageDto movie = movieService.findResponseByTitle(title);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Example_header", "dummy_value");
        return new ResponseEntity(movie, httpHeaders, HttpStatus.ACCEPTED);
    }


    //dodawanie fimów
    @PostMapping(path = "/api/movie")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createMovie(@RequestBody MovieRequest movie){
        movieService.save(movie);
    }


    //szukanie fimów po gatunku
    @GetMapping(path = "/api/movieGenre")
    public ResponseEntity<MovieMainPageDto> findByGenre(@RequestParam Genre genre){
        final MovieMainPageDto movie = movieService.findResponseByGenre(genre);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Example_header", "dummy_value");
        return new ResponseEntity(movie, httpHeaders, HttpStatus.ACCEPTED);
    }

    //szukanie fimów po id
    @GetMapping("api/get/{id}")
    public MovieMainPageDto getById(@PathVariable Long id){
        return this.readMovie.readById(id);
    }
}
