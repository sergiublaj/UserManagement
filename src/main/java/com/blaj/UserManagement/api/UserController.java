package com.blaj.UserManagement.api;

import com.blaj.UserManagement.exception.UserErrorResponse;
import com.blaj.UserManagement.exception.UserNotFoundException;
import com.blaj.UserManagement.model.User;
import com.blaj.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) throws UserNotFoundException {
        User foundUser = userService.getUser(userId);

        if (foundUser == null) {
            throw new UserNotFoundException("User " + userId + " not found!");
        }

        return userService.getUser(userId);
    }

    @PostMapping("/users")
    public int addUser(@RequestBody User newUser) {
        userService.saveUser(newUser);

        return 1;
    }

    @PutMapping("/users")
    public int updateUser(@RequestBody User newUser) {
        userService.saveUser(newUser);

        return 1;
    }

    @DeleteMapping("/users/{userId}")
    public int deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);

        return 1;
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleUserNotFound(UserNotFoundException exception) {
        UserErrorResponse error = new UserErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
