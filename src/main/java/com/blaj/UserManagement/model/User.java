package com.blaj.UserManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;
   @Column(name = "name")
   private String name;
   @Column(name = "email")
   private String email;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "animal_id")
   private Animal animal;

   @JsonManagedReference
   @OneToMany(mappedBy="user",
      cascade= {CascadeType.PERSIST, CascadeType.MERGE,
         CascadeType.DETACH, CascadeType.REFRESH})
   private List<Mark> marks = new ArrayList<>();

   public User() {
   }

   public User(String name, String email) {
      this.name = name;
      this.email = email;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Animal getAnimal() {
      return animal;
   }

   public void setAnimal(Animal animal) {
      this.animal = animal;
   }

   public List<Mark> getMarks() {
      return marks;
   }

   public void setMarks(List<Mark> marks) {
      for (Mark mark : marks) {
         mark.setUser(this);
      }
      this.marks = marks;
   }

   @Override
   public String toString() {
      return "User{" +
         "id=" + id +
         ", name='" + name + '\'' +
         ", email='" + email + '\'' +
         ", animal=" + animal +
         ", marks=" + marks +
         '}';
   }
}
