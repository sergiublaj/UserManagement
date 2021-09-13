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
@CrossOrigin
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
    public User addUser(@RequestBody User newUser) {
        return userService.saveUser(newUser);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User updatedUser, @PathVariable int userId) {
        return userService.updateUser(updatedUser, userId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
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
