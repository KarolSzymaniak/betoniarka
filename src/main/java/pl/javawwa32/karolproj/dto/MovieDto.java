package pl.javawwa32.karolproj.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Data
public class MovieDto {

    private Long movieId;

    @NotBlank(message = "Please provide genere")
    private String genere;
    @NotBlank(message = "Please provide description")
    private String description;
    @NotBlank(message = "Please provide avgScore")
    private int avgScore;

    private int noOfCopies;
}
