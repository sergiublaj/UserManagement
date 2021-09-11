package com.blaj.UserManagement.dao;

import com.blaj.UserManagement.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PreDestroy;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
   @Autowired
   private SessionFactory sessionFactory;

   @PreDestroy
   public void closeSessionFactory() {
      sessionFactory.close();
   }

   @Override
   public void saveUser(User newUser) {
      Session session = sessionFactory.openSession();

      session.save(newUser);
   }

   @Override
   public User getUser(int userId) {
      Session session = sessionFactory.openSession();

      return session.get(User.class, userId);
   }

   @Override
   public List<User> getAllUsers() {
      Session session = sessionFactory.openSession();

      return (List<User>) session.createQuery("from User").getResultList();
   }

   @Override
   public List<User> getAllUsersWithGivenName(String givenName) {
      Session session = sessionFactory.openSession();

      return (List<User>) session.createQuery("from User U where U.name='" + givenName + "'").list();
   }

   @Override
   public void setUserEmail(int userId, String newEmail) {
      Session session = sessionFactory.openSession();

      User foundUser = session.get(User.class, userId);

      foundUser.setEmail(newEmail);
   }


   @Override
   public void deleteUser(int userId) {
      Session session = sessionFactory.openSession();

      // Varianta 1
//      List<User> userList = session.createQuery("from User U where U.id='" + userId + "'").list();
//
//      for (User crtUser : userList) {
//         session.delete(crtUser);
//      }
//
//      session.getTransaction().commit();

      // Varianta 2
      session.createQuery("delete from User U where U.id = '" + userId + "'").executeUpdate();
   }
}
