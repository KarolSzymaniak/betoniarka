package pl.javawwa32.karolproj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.javawwa32.karolproj.dto.MovieMainPageDto;
import pl.javawwa32.karolproj.dto.MovieRequest;
import pl.javawwa32.karolproj.dto.OrderDto;
import pl.javawwa32.karolproj.service.MovieService;
import pl.javawwa32.karolproj.service.OrderService;
import pl.javawwa32.karolproj.service.ReadOrder;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrderService orderService;
    private final ReadOrder readOrder;

    //dodawanie fimów
//    @PostMapping(path = "/api/order")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public void createMovie(@RequestBody MovieRequest movie){
//        orderService.save(movie);
//    }

    //szukanie zamówień po id
    @GetMapping("api/order/{id}")
    public OrderDto getById(@PathVariable Long id){
        return this.readOrder.readById(id);
    }

}
