package com.example.demo.service.impl;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    /**
     * Test method for {@link UserServiceImpl#deleteUser(long)}.
     */
    @Test
    void deleteUser() {
        // create an instance of UserServiceImpl with the mocked UserRepository as dependency
        UserService userService = new UserServiceImpl(userRepository);

        // call the method we want to test
        userService.deleteUser(1L);

        // since the above method is void and there is nothing returned to assert,
        // verify that the deleteById method of the UserRepository was called with the correct argument
        Mockito.verify(userRepository).deleteById(1L);
    }
}