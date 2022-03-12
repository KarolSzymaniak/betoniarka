package pl.javawwa32.karolproj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javawwa32.karolproj.dto.MovieMainPageDto;
import pl.javawwa32.karolproj.dto.OrderDto;
import pl.javawwa32.karolproj.repository.MoviesRepository;
import pl.javawwa32.karolproj.repository.OrdersRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReadOrder {

    @Autowired
    private final OrdersRepository ordersRepository;

    public OrderDto readById(Long id){
        return OrderMapper.mapForMainPage(ordersRepository.findById(id).get());
    }

}