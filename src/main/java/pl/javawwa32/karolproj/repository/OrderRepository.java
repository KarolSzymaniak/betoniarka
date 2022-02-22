package pl.javawwa32.karolproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javawwa32.karolproj.model.Movie;
import pl.javawwa32.karolproj.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
