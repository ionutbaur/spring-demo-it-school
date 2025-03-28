package com.example.demo.service;

import com.example.demo.model.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserById(long id);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(long id, UserDTO userDTO);

    void deleteUser(long id);
}
