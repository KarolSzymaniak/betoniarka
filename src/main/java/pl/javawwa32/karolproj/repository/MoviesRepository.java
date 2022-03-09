package pl.javawwa32.karolproj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.javawwa32.karolproj.model.Movie;
import pl.javawwa32.karolproj.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoviesRepository extends CrudRepository<Movie, Long> {

  //  Optional<Movie> findByTitle(String title);


    Movie findByTitle(String title);

  // Page<Movie> findByTitle(String name, Pageable pageable);




    Movie findByAvgScore(double avgScore);


    //do wyszukiwania wszystkich filmów
    //List<Movie> findByOrderByAvgScoreDesc();

    List<Movie> findByOrderByAvgScoreDesc(Pageable pageable);

    List<Movie> findByOrderByReleaseDate();
}
