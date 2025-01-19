package com.maliksa.reviewms.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {





    // ctrl+ alt +o
    @Autowired
    ReviewService reviewService;
    @GetMapping("/getAllReview")
    public List<Review> getAllReview(@RequestParam int companyId)
    {
        System.out.println("RDDD");
        return reviewService.getAllReviews(companyId);
    }
    @PostMapping
    public ResponseEntity< String> createReview(@RequestParam int companyId,@RequestBody Review review)
    {
        System.out.println(companyId+"REVIEW ID");
        boolean review1 = reviewService.createReview(companyId, review);
        if(review1)
        {
            return new ResponseEntity<>("Review Inserted Successfully",HttpStatus.CREATED);

        }
        else{
            return new ResponseEntity<>("Review Not Successfully Inserted",HttpStatus.NOT_FOUND);
           }
    }
    @DeleteMapping("/{reviewid}")
    public ResponseEntity< String> deleteById(@PathVariable int reviewid)
    {

        boolean b  = reviewService.deleteReviewById(reviewid);
            if(b)
            {
                return  new ResponseEntity<>("Delete Record Successfully",HttpStatus.OK);
            }else {
                return  new ResponseEntity<>("Record Not Deleted",HttpStatus.NOT_FOUND);
            }
    }
        @GetMapping("/{reviewId}")
     public ResponseEntity<   Review >getReviewById(@PathVariable int reviewId)
        {
            return new ResponseEntity<>(reviewService.getReviewById(reviewId),HttpStatus.OK);
        }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String >updateReview(@PathVariable int reviewId,@RequestBody Review review)
    {
 boolean isReviewed=   reviewService.updateReview( reviewId, review);
 if(isReviewed)
 {
     return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);

 }else {
     return new ResponseEntity<>("Review Not Updated ",HttpStatus.CONFLICT);

 }
    }

}
