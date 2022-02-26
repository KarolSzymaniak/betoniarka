package pl.javawwa32.karolproj.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movieCopy")
public class MovieCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "copy_id")
    private Long copyId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movieId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "no_of_copies")
    private int noOfCopies;

}
