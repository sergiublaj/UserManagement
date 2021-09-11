package com.blaj.UserManagement.model;

import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;
   @Column(name = "name")
   private String name;
   @Column(name = "age")
   private int age;
   @OneToOne(mappedBy = "animal")
   private User user;

   public Animal() {
   }

   public Animal(String name, int age) {
      this.name = name;
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   @Override
   public String toString() {
      return "Animal{" +
         "id=" + id +
         ", name='" + name + '\'' +
         ", age=" + age +
         ", user=" + user.getId() +
         '}';
   }
}
