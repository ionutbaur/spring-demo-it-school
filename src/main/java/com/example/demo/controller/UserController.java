package com.example.demo.controller;

import com.example.demo.model.UserDTO;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Swagger annotation to group the API endpoints under the "User Manager" tag
@Tag(name = "User Manager", description = "User Manager API that manipulates all the operations related to users")
@RestController // indicates that this class is a REST controller and exposes RESTful endpoints
@RequestMapping("/users") // base URL path for all endpoints in this controller
public class UserController {

    private final UserService userService;

    // dependency injection of UserService using constructor (recommended way)
    public UserController(UserService userService) { // given that UserService is an interface, Spring will automatically inject the only implementation available of this interface (UserServiceImpl) into this constructor
        this.userService = userService;
    }

    // below we are exposing the endpoints of this API

    @Operation(summary = "Find a user by id", description = "Find a user by their id and return the found user")
    @GetMapping("{id}")
    public UserDTO findUser(@PathVariable long id) { // @PathVariable annotation is used to extract the dynamic '{id}' from the URL and bind it to the method parameter
        return userService.findUserById(id);
    }

    @Operation(summary = "Find all users", description = "Find all users in the database and return them in a list")
    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userService.findAllUsers();
    }

    @Operation(summary = "Add a new user", description = "Add a new user to the database along with their address and return the created user")
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) { // @RequestBody annotation needed because the request body is a JSON object that holds other JSON objects (AddressDTO and an array of OrderDTO)
        return userService.createUser(userDTO);
    }

    @Operation(summary = "Update a user", description = "Update a user by their id and return the updated user")
    @PutMapping("{id}")
    public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @Operation(summary = "Delete a user", description = "Delete a user by their id. An HTTP 200 OK response is returned if the user was deleted successfully")
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
