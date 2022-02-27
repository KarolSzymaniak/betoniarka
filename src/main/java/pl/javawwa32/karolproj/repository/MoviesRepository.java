package pl.javawwa32.karolproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.javawwa32.karolproj.model.Movie;

import java.util.Optional;

@Repository
public interface MoviesRepository extends CrudRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);

}
