package pl.javawwa32.karolproj.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

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
    @Setter(AccessLevel.NONE)
    @Column(name = "order_id")
    private Long OrderId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private  Set<MovieCopy> copyId;

    @Column(name = "price")
    private BigDecimal totalPrice;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "order_date")
    private LocalDateTime orderPlacedDate;  // cena całego zamówienia ustawiana przy zwrocie

    private BigDecimal pricePerDay; //koszt jednego dania wypożyczenia zamówienia

}
