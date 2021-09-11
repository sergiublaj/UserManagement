package com.blaj.UserManagement.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Configuration
public class AppConfig {
   @PersistenceUnit
   private EntityManagerFactory entityManagerFactory;

   @Bean
   public SessionFactory sessionFactory() {
      return entityManagerFactory.unwrap(SessionFactory.class);
   }
}
