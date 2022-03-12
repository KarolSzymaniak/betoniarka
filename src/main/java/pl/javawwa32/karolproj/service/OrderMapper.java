package pl.javawwa32.karolproj.service;

import org.springframework.stereotype.Component;
import pl.javawwa32.karolproj.dto.MovieMainPageDto;
import pl.javawwa32.karolproj.dto.OrderDto;
import pl.javawwa32.karolproj.model.Movie;
import pl.javawwa32.karolproj.model.Order;


@Component
public class OrderMapper {
    public static OrderDto mapForMainPage(Order order) {
        return OrderDto.builder()
                .orderId(order.getOrderId())
                .user(order.getUser())
                .orderStatus(order.getOrderStatus())
                .address(order.getAddress())
                .copyId(order.getCopyId())
                .orderPlacedDate(order.getOrderPlacedDate())
                .pricePerDay(order.getPricePerDay())
                .build();
    }
}
