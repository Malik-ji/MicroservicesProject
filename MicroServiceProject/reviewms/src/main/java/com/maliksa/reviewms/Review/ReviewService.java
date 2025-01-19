package com.maliksa.reviewms.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(int id);
//    List<Review> findByCompanyId(int companyId);
    boolean updateReview(int reviewId,Review review);
    boolean deleteReviewById( int reviewid);
    boolean createReview(int companyId, Review review);

//    @GetMapping("/reviews/{reviewId}")
    Review getReviewById(  int reviewId);

}
