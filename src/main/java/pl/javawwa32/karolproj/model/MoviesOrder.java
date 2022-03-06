package pl.javawwa32.karolproj.model;

import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "orders")

public class MoviesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private long orderId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "moviesOrder", cascade = CascadeType.PERSIST)
    private Set<MovieCopy> movieCopies;

    @Column(name = "order_places_date")
    private LocalDateTime orderPlacesDate;

    @Enumerated
    @Column(name = "status")
    private OrderStatus orderStatus;

    @Column(name = "status_change_date")
    private LocalDateTime statusChangeDate;

    private BigDecimal totalPrice; //cena za całe zamówienie
    private BigDecimal pricePerDay; //koszt jednego dnia wypożyczenia zamówienia

}
