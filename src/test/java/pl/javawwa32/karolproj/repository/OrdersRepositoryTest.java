package pl.javawwa32.karolproj.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import pl.javawwa32.karolproj.model.Order;
import pl.javawwa32.karolproj.model.OrderStatus;
import pl.javawwa32.karolproj.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrdersRepositoryTest {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void userFromOrderShouldBeTheSameAsUser(){



        //given
        User user = User.builder()
                .email("email@email.com")
                .password("password")
                .build();

        Optional<User> foundUserOptional = usersRepository.findByEmail(user.getEmail());
        Assertions.assertThat(foundUserOptional.isEmpty()).isTrue();

        Order order = Order.builder()
                .orderStatus(OrderStatus.ACCEPTED)
                .orderPlacedDate(LocalDateTime.now())
                .user(user)
                .build();

        //when
        //usersRepository.save(user);   //zapisze sie poprzez ordersRepository, poniewaz jest relacja Order - User
        ordersRepository.save(order);
        Assertions.assertThat(order.getOrderId()).isNotNull();  //id ustawiony przez metode save

        var foundOrderOptional = ordersRepository.findById(order.getOrderId());

        //then
        Assertions.assertThat(foundOrderOptional.isPresent()).isTrue();
        var foundOrder = foundOrderOptional.get();
        Assertions.assertThat(foundOrder.getUser()).isNotNull();
        Assertions.assertThat(foundOrder.getUser().getEmail()).isNotNull();
        Assertions.assertThat(foundOrder.getUser().getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    void retrieves_paged_orders_for_user() {
        //given
        User user = User.builder()
                .email("email@email.com")
                .password("password")
                .build();
        var o1 = Order.builder()
                .orderStatus(OrderStatus.ACCEPTED)
                .orderPlacedDate(LocalDateTime.now())
                .price(BigDecimal.valueOf(5))
                .user(user)
                .build();
        var o2 = Order.builder()
                .orderStatus(OrderStatus.TURNED)
                .orderPlacedDate(LocalDateTime.now().minusDays(15))
                .price(BigDecimal.valueOf(15))
                .user(user)
                .build();
        var o3 = Order.builder()
                .orderStatus(OrderStatus.TURNED)
                .orderPlacedDate(LocalDateTime.now().minusDays(30))
                .price(BigDecimal.valueOf(30))
                .user(user)
                .build();
        var o4 = Order.builder()
                .orderStatus(OrderStatus.TURNED)
                .orderPlacedDate(LocalDateTime.now().minusDays(45))
                .price(BigDecimal.valueOf(45))
                .user(user)
                .build();



        var orders = Arrays.asList(o1, o2, o3, o4);
        ordersRepository.saveAll(orders);

        //when
        var page1 = PageRequest.of(0, 2).withSort(Sort.by(Sort.Direction.DESC, "orderPlacedDate"));
        var page2 = PageRequest.of(1, 2).withSort(Sort.by(Sort.Direction.DESC, "orderPlacedDate"));

        Assertions.assertThat(user.getUserId()).isNotNull();
        var ordersForPage1 = ordersRepository.findByUser_userId(user.getUserId(), page1);
        var ordersForPage2 = ordersRepository.findByUser_userId(user.getUserId(), page2);

        //then
        Assertions.assertThat(ordersForPage1).isNotNull();
        Assertions.assertThat(ordersForPage1.getTotalPages()).isEqualTo(2);
        Assertions.assertThat(ordersForPage1.getTotalElements()).isEqualTo(4);
        var orderPage1 = ordersForPage1.getContent();
        Assertions.assertThat(orderPage1).hasSize(2);
        var ro1 = orderPage1.get(0);    //retrieved o1
        Assertions.assertThat(ro1).isNotNull();
        Assertions.assertThat(ro1.getPrice()).isEqualTo(BigDecimal.valueOf(5));
        var ro4 = ordersForPage2.getContent().get(1);    //o4
        Assertions.assertThat(ro4).isNotNull();
        Assertions.assertThat(ro4.getPrice()).isEqualTo(BigDecimal.valueOf(45));
    }

}
