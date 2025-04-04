package com.example.demo.service;

import com.example.demo.model.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findAllOrders(long userId);

    OrderDTO placeOrder(long userId, OrderDTO orderDTO);

    List<OrderDTO> findOrdersByDescription(String description);
}
