package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.model.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.ModelConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Annotation to tell Spring that this is a bean of type Service (usually contains business logic)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findUserById(long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow();
        return ModelConverter.convertToUserDTO(foundUser);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream()
                .map(ModelConverter::convertToUserDTO)
                .toList();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = ModelConverter.convertToUser(userDTO);
        User createdUser = userRepository.save(user);

        return ModelConverter.convertToUserDTO(createdUser);
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) {
        User user = ModelConverter.convertToUser(userDTO);
        user.setId(id);

        User updatedUser = userRepository.save(user);

        return ModelConverter.convertToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
