package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.OrderDTO;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    private static final long USER_ID = 12345L;
    private static final String ORDER_ID = "someFakeOrderId";
    private static final String ORDER_DESCRIPTION = "fake description";

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderServiceImpl(orderRepository, userRepository);
    }

    @Test
    void findAllOrders() {
    }

    @Test
    void placeOrder() {
        OrderDTO orderDTO = new OrderDTO(ORDER_ID, ORDER_DESCRIPTION);

        Mockito.when(userRepository.findById(USER_ID))
                .thenReturn(Optional.of(user));
        Order savedOrderInDB = new Order("fake db description", user);
        Mockito.when(orderRepository.save(Mockito.argThat(ord ->
                        ORDER_DESCRIPTION.equals(ord.getDescription()))))
                .thenReturn(savedOrderInDB);

        OrderDTO placedOrder = orderService.placeOrder(USER_ID, orderDTO);
        assertEquals("fake db description", placedOrder.description());
        assertNotEquals(ORDER_ID, placedOrder.id());
    }

    @Test
    void placeOrder_userNotFound() {
        OrderDTO orderDTO = new OrderDTO(ORDER_ID, ORDER_DESCRIPTION);
        Mockito.when(userRepository.findById(USER_ID))
                .thenReturn(Optional.empty());

        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
            orderService.placeOrder(USER_ID, orderDTO);
        });
        assertEquals("404 NOT_FOUND \"I can't find user with id: 12345\"", exception.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
    void findOrdersByDescription() {
    }
}