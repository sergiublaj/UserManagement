package com.blaj.UserManagement.dao;

import com.blaj.UserManagement.model.Mark;
import com.blaj.UserManagement.model.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PreDestroy;

@Repository
@Transactional
public class MarkDAOImpl implements MarkDAO{
   @Autowired
   private SessionFactory sessionFactory;

   @PreDestroy
   public void closeSessionFactory() {
      sessionFactory.close();
   }

   @Override
   public void saveMark(Mark mark) {
      Session session = sessionFactory.openSession();

      session.save(mark);
   }

   @Override
   public void saveReview(Review review) {
      Session session = sessionFactory.openSession();

      session.save(review);
   }
}
