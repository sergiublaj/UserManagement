package com.blaj.UserManagement.dao;

import com.blaj.UserManagement.model.User;

import java.util.List;

public interface UserDAO {
    User getUser(int id);

    List<User> getAllUsers();

    void saveUser(User newUser);

    void updateUser(User updatedUser, int userId);

    void deleteUser(int userId);
}
