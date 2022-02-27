package pl.javawwa32.karolproj.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class OrderHistoryDto {

    private Long orderHistoryId;
    //private Order orderId;
    //private Copy copyId;
}
