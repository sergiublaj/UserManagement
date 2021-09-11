package com.blaj.UserManagement.service;

import com.blaj.UserManagement.dao.UserDAO;
import com.blaj.UserManagement.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   private final UserDAO userDAO;

   public UserService(UserDAO userDAO) {
      this.userDAO = userDAO;
   }

   public void saveUser(User newUser) {userDAO.saveUser(newUser);}

   public User getUser(int id) {
      return userDAO.getUser(id);
   }

   public List<User> getAllUsers() { return userDAO.getAllUsers(); }

   public List<User> getAllUsersWithGivenName(String givenName) { return userDAO.getAllUsersWithGivenName(givenName); }

   public void setUserEmail(int userId, String newEmail) { userDAO.setUserEmail(userId, newEmail);}

   public void deleteUser(int userId) { userDAO.deleteUser(userId);}
}
