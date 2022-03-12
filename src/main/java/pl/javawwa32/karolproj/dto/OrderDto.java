package pl.javawwa32.karolproj.dto;

import lombok.*;
import pl.javawwa32.karolproj.model.MovieCopy;
import pl.javawwa32.karolproj.model.OrderStatus;
import pl.javawwa32.karolproj.model.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDto {



    private Long orderId;


    private User user;


    private OrderStatus orderStatus;


    private String address;


    private Set<MovieCopy> copyId;


    private BigDecimal totalPrice;


    private LocalDateTime returnDate;


    private LocalDateTime orderPlacedDate;  // cena całego zamówienia ustawiana przy zwrocie

    private BigDecimal pricePerDay; //koszt jednego dania wypożyczenia zamówienia
}
