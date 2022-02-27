package pl.javawwa32.karolproj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javawwa32.karolproj.model.Order;
import pl.javawwa32.karolproj.model.User;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {


    //wyszukouje zamówienia danego usera,  zwraca page
    Page<Order> findByUser_userId(Long userId, Pageable pagable);
}
