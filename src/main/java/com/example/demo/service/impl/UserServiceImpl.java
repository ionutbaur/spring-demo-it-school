package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.model.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUserById(long id) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(userDTO.name(), userDTO.email(), userDTO.age());
        User ceatedUser = userRepository.save(user);

        return new UserDTO(ceatedUser.getId(), ceatedUser.getName(), ceatedUser.getEmail(), ceatedUser.getAge());
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }
}
