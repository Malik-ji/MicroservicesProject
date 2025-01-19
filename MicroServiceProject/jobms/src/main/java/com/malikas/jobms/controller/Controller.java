package com.malikas.jobms.controller;

import com.malikas.jobms.entity.JobWithComp;
import com.malikas.jobms.entity.Jobs;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class Controller {

         private Logger logger= LoggerFactory.getLogger(Controller.class);
    @Autowired
    private JobService jobsService;
int attempt=0;
    // Get all jobs
    @GetMapping
//    @CircuitBreaker(name = "companyBraker",fallbackMethod = "companyBreakerFallBack")
//    @Retry(name = "companyBraker" ,fallbackMethod =  "companyBreakerFallBack")
    @RateLimiter(name = "companyBraker" )
    public List< JobWithComp> getAllJobs() {
//        System.out.println();
        System.out.println("attempt value increases"+ ++attempt);
        List<JobWithComp> allJobs = jobsService.getAllJobs();
        logger.info("GetAll Jobs :: "+allJobs);
        return allJobs;

    }
    public List<String> companyBreakerFallBack(Exception e)
    {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("Url is Down");
        return objects;
    }
    // Get job by ID
    @GetMapping("/{id}")
    public ResponseEntity<Jobs> getJobById(@PathVariable int id) {
        Optional <Jobs> job = jobsService.getJobById(id);
        if (job.isPresent()) {
            return new ResponseEntity<>(job.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new job
    @PostMapping
    public ResponseEntity<Jobs> createJob(@RequestBody Jobs job) {
        boolean exists = jobsService.existsById(job.getId());
        if (exists) {
            return new ResponseEntity<>(job,HttpStatus.CONFLICT);
        }
        Jobs savedJob = jobsService.saveJob(job);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    // Update an existing job
    @PutMapping("/{id}")
    public ResponseEntity<Jobs> updateJob(@PathVariable int id, @RequestBody Jobs job) {
        Optional<Jobs> existingJobOpt = jobsService.getJobById(id);
        if (existingJobOpt.isPresent()) {
            Jobs updatedJob = jobsService.updateJob(id, job); // Delegates update logic to the service layer
            return new ResponseEntity<>(updatedJob, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Delete a job by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable int id) {

        Optional<Jobs> job = jobsService.getJobById(id);
        if (job.isPresent()) {
            jobsService.deleteJob(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
