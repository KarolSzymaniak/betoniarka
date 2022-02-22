package pl.javawwa32.karolproj.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private String address;
    //private  Copy copyId;
    //private User userId;
    private BigDecimal price;
    private LocalDateTime returnDate;
    private LocalDateTime orderDate;

}
