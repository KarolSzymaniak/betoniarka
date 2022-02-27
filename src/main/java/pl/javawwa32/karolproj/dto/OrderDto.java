package pl.javawwa32.karolproj.dto;

import lombok.Data;
import pl.javawwa32.karolproj.model.MovieCopy;
import pl.javawwa32.karolproj.model.OrderStatus;
import pl.javawwa32.karolproj.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class OrderDto {

    private Long OrderId;

    @NotNull
    private OrderStatus orderStatus;

    @NotBlank(message = "Please provide address")
    private String address;

    private MovieCopy copyId;
    private User userId;

    @NotNull
    private BigDecimal price;

    @NotNull
    private LocalDateTime returnDate;

    @NotNull
    private LocalDateTime orderDate;
}
