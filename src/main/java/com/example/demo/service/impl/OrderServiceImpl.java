package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.OrderDTO;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.OrderService;
import com.example.demo.util.ModelConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<OrderDTO> findAllOrders(long userId) {
        return orderRepository.findOrdersByUser_Id(userId)
                .stream()
                .map(ModelConverter::convertToOrderDTO)
                .toList();
    }

    @Override
    public OrderDTO placeOrder(long userId, OrderDTO orderDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("I can't find user with id: " + userId));
        Order order = new Order(orderDTO.description(), user);
        Order createdOrder = orderRepository.save(order);

        return ModelConverter.convertToOrderDTO(createdOrder);
    }

    @Override
    public List<OrderDTO> findOrdersByDescription(String description) {
        return orderRepository.findOrdersByDescription(description)
                .stream()
                .map(ModelConverter::convertToOrderDTO)
                .toList();
    }
}
