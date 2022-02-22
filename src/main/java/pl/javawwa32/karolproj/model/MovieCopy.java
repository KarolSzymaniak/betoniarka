package pl.javawwa32.karolproj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long copyId;
    // private Movie movieId;
    private int noOfCopies;

}
