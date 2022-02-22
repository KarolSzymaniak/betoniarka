package pl.javawwa32.karolproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javawwa32.karolproj.model.Movie;
import pl.javawwa32.karolproj.model.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
