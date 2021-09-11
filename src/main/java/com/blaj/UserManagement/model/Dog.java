package com.blaj.UserManagement.model;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {
   public Dog() {
   }

   public Dog(String name, int age) {
      super(name, age);
   }
}
