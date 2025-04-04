package com.example.demo.service;

import com.example.demo.model.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO findUserById(long id);

    List<UserDTO> findAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(long id, UserDTO userDTO);

    void deleteUser(long id);
}
