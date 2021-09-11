package com.blaj.UserManagement.dao;

import com.blaj.UserManagement.model.Mark;
import com.blaj.UserManagement.model.Review;

public interface MarkDAO {
   void saveMark(Mark mark);

   void saveReview(Review review);
}
