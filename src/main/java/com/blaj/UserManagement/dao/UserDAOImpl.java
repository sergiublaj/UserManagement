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
        return session.get(User.class, userId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from User").getResultList();
    }

    @Override
    public void saveUser(User newUser) {
        Session session = sessionFactory.openSession();
        session.save(newUser);
        session.close();
    }

    @Override
    public void updateUser(User updatedUser, int userId) {
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query theQuery = session.createQuery("update User set name=:name, email=:email where id=:userId");
        theQuery.setParameter("name", updatedUser.getName());
        theQuery.setParameter("email", updatedUser.getEmail());
        theQuery.setParameter("userId", userId);
        theQuery.executeUpdate();
        txn.commit();
    }

    @Override
    public void deleteUser(int userId) {
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query theQuery = session.createQuery("delete from User U where U.id =:userId ");
        theQuery.setParameter("userId", userId);
        theQuery.executeUpdate();
        txn.commit();
    }
}
