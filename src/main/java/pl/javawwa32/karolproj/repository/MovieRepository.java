package pl.javawwa32.karolproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javawwa32.karolproj.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
