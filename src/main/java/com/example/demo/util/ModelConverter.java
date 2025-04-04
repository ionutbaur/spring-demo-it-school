package com.example.demo.util;

import com.example.demo.entity.Address;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.model.AddressDTO;
import com.example.demo.model.OrderDTO;
import com.example.demo.model.UserDTO;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

// helper class to convert between entity and DTO classes
public class ModelConverter {

    private ModelConverter() {
        // private constructor to prevent instantiation - should be a utility class with only static methods
    }

    public static UserDTO convertToUserDTO(User user) {
        Address address = user.getAddress();
        AddressDTO addressDTO = convertToAddressDTO(address);

        List<Order> orders = user.getOrders();
        List<OrderDTO> orderDTOs = orders.stream()
                .map(ModelConverter::convertToOrderDTO)
                .toList();

        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getAge(), addressDTO, orderDTOs);
    }

    public static User convertToUser(UserDTO userDTO) {
        AddressDTO addressDTO = userDTO.address();
        Address address = convertToAddress(addressDTO);

        List<OrderDTO> orderDTOs = userDTO.orders();
        List<Order> orders = Collections.emptyList();
        if (orderDTOs != null) {
            orders = orderDTOs.stream()
                    .map(ModelConverter::convertToOrder)
                    .toList();
        }

        return new User(userDTO.name(), userDTO.email(), userDTO.age(), address, orders);
    }

    public static AddressDTO convertToAddressDTO(Address address) {
        /*if (address == null) {
            return null;
        }

        return new AddressDTO(address.getCity(), address.getStreet(), address.getNumber(), address.getZipCode());*/

        // same as above commented but in functional style
        return Optional.ofNullable(address)
                .map(addr -> new AddressDTO(addr.getCity(), addr.getStreet(), addr.getNumber(), addr.getZipCode()))
                .orElse(null);
    }

    public static Address convertToAddress(AddressDTO addressDTO) {
        return Optional.ofNullable(addressDTO)
                .map(addr -> new Address(addr.city(), addr.street(), addr.number(), addr.zipCode()))
                .orElse(null);
    }

    public static OrderDTO convertToOrderDTO(Order order) {
        return Optional.ofNullable(order)
                .map(ord -> new OrderDTO(ord.getId(), ord.getDescription()))
                .orElse(null);
    }

    public static Order convertToOrder(OrderDTO orderDTO) {
        return Optional.ofNullable(orderDTO)
                .map(ord -> new Order(ord.description()))
                .orElse(null);
    }
}
