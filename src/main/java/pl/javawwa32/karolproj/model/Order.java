package pl.javawwa32.karolproj.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private Long orderId;
    private OrderStatus orderStatus;
    private String address;
    private  Copy copyId;
    private User userId;
    private BigDecimal price;
    private LocalDateTime returnDate;
    private LocalDateTime orderDate;


}
