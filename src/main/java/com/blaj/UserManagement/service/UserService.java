package com.blaj.UserManagement.service;

import com.blaj.UserManagement.dao.UserDAO;
import com.blaj.UserManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public void saveUser(User newUser) {
        userDAO.saveUser(newUser);
    }

    @Transactional
    public void updateUser(User updatedUser, int userId) {
        userDAO.updateUser(updatedUser, userId);
    }

    @Transactional
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}
