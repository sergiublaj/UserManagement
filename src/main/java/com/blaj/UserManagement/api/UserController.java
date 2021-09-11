package com.blaj.UserManagement.api;

import com.prototype.springBeans.exception.UserErrorResponse;
import com.prototype.springBeans.exception.UserNotFoundException;
import com.prototype.springBeans.model.User;
import com.prototype.springBeans.service.UserService;
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

   @GetMapping("/user/{userId}")
   public User getUser(@PathVariable int userId) throws UserNotFoundException {
      User foundUser = userService.getUser(userId);

      if (foundUser == null) {
         throw new UserNotFoundException("User " + userId + " not found!");
      }

      return userService.getUser(userId);
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
