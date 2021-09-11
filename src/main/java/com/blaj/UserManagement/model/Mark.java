package com.blaj.UserManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mark")
public class Mark {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;
   @Column(name = "grade")
   private int grade;
   @Column(name = "klass")
   private String klass;

   @JsonBackReference
   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.DETACH, CascadeType.REFRESH})
   @JoinColumn(name = "user_id")
   private User user;

   @JsonManagedReference
   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "mark_id")
   private List<Review> reviews;

   public Mark() {
   }

   public Mark(int grade, String klass) {
      this.grade = grade;
      this.klass = klass;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getGrade() {
      return grade;
   }

   public void setGrade(int grade) {
      this.grade = grade;
   }

   public String getKlass() {
      return klass;
   }

   public void setKlass(String Klass) {
      klass = klass;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public List<Review> getReviews() {
      return reviews;
   }

   public void setReviews(List<Review> reviews) {
      this.reviews = reviews;
   }

   @Override
   public String toString() {
      return "Mark{" +
         "id=" + id +
         ", grade=" + grade +
         ", klass='" + klass + '\'' +
         ", reviews=" + reviews +
         ", user=" + user.getId() +
         '}';
   }
}
