package com.blaj.UserManagement.dao;

import com.blaj.UserManagement.model.User;

import java.util.List;

public interface UserDAO {
   void saveUser(User newUser);

   User getUser(int id);

   List<User> getAllUsers();

   List<User> getAllUsersWithGivenName(String givenName);

   void setUserEmail(int userId, String newEmail);

   void deleteUser(int userId);
}
