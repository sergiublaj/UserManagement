package com.blaj.UserManagement.service;

import com.blaj.UserManagement.dao.MarkDAO;
import com.blaj.UserManagement.model.Mark;
import com.blaj.UserManagement.model.Review;
import org.springframework.stereotype.Service;

@Service
public class MarkService {
   private final MarkDAO markDAO;

   public MarkService(MarkDAO markDAO) {
      this.markDAO = markDAO;
   }

   public void saveMark(Mark mark) {
      markDAO.saveMark(mark);
   }

   public void saveReview(Review review) {
      markDAO.saveReview(review);
   }
}
