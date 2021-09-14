package com.blaj.UserManagement.dao;

import com.blaj.UserManagement.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(int userId) {
        Session session = sessionFactory.openSession();
        User foundUser = session.get(User.class, userId);
        session.close();
        return foundUser;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> userList = session.createQuery("from User").getResultList();
        session.close();
        return userList;
    }

    @Override
    public User saveUser(User newUser) {
        Session session = sessionFactory.openSession();
        session.save(newUser);
        session.close();
        return newUser;
    }

    @Override
    public User updateUser(User updatedUser, int userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query theQuery = session.createQuery("update User set name=:name, email=:email where id=:userId");
        theQuery.setParameter("name", updatedUser.getName());
        theQuery.setParameter("email", updatedUser.getEmail());
        theQuery.setParameter("userId", userId);
        theQuery.executeUpdate();
        transaction.commit();
        session.close();
        updatedUser.setId(userId);
        return updatedUser;
    }

    @Override
    public int deleteUser(int userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query theQuery = session.createQuery("delete from User where id =:userId");
        theQuery.setParameter("userId", userId);
        theQuery.executeUpdate();
        transaction.commit();
        session.close();
        return userId;
    }
}
