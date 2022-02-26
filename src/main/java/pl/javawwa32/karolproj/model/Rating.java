package pl.javawwa32.karolproj.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "rating_id")
    private Long ratingId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order orderId;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movieId;

    @Column(name = "rating")
    private int rating;
}
