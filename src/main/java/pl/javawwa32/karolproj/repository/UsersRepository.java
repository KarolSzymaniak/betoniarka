package pl.javawwa32.karolproj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javawwa32.karolproj.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {


  //  Optional<User> findByEmail(String email);

    User findByEmail(String email);

  //  List<User> findByName(String name);

    Page<User> findByName(String name, Pageable pageable);
}
