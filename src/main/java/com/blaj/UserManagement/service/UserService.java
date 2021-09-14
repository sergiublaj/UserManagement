package com.blaj.UserManagement.service;

import com.blaj.UserManagement.dao.UserDAO;
import com.blaj.UserManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User saveUser(User newUser) {
        return userDAO.saveUser(newUser);
    }

    public User updateUser(User updatedUser, int userId) {
        return userDAO.updateUser(updatedUser, userId);
    }

    public int deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }
}
