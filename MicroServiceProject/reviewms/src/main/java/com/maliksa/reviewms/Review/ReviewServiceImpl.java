package com.maliksa.reviewms.Review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public List<Review> getAllReviews(int id) {
        return reviewRepo.findByCompanyId(id);
    }

//    @Override
//    public List<Review> findByCompanyId(int companyId) {
//        reviewRepo.findById(companyId);
//        return null;
//    }

    @Override
    public boolean updateReview(int reviewId,Review updreview) {

        Review review = reviewRepo.findById(reviewId).orElse(null);
        if( review!=null)
       {
           review.setTitle(updreview.getTitle());
           review.setDescription(updreview.getDescription());
           review.setRating(updreview.getRating());
           review.setCompanyId(updreview.getCompanyId());
            reviewRepo.save(updreview);
            return  true;
       }
       else {
      return      false;
       }

//        ctrl + alt +v  save refrence
    }
 @Override
    public boolean deleteReviewById( int rid) {
     System.out.println("rid = " + rid);
     Review review1 = reviewRepo.findById(rid).orElse(null);
     if (review1!=null) {

                reviewRepo.deleteById(rid); // Delete the review from the repository
                return true;

        }
        return false;
    }

    @Override
    public boolean createReview(int companyId, Review review) {
        if(companyId!=0) {
            review.setCompanyId(companyId);
            reviewRepo.save(review);
        return  true;
        }
        return false;
        }

    @Override
    public Review getReviewById( int reviewId) {
       return reviewRepo.findById(reviewId).orElse(null);
    }

}
