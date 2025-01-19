package com.malikas.jobms.controller;

import com.malikas.jobms.CompanyRef;
import com.malikas.jobms.entity.Company;
import com.malikas.jobms.entity.JobWithComp;
import com.malikas.jobms.entity.Jobs;
import com.malikas.jobms.repository.JobsRepository;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobService {
    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CompanyRef companyRef;
    // Get all jobs

    @Autowired
    ReviewClient reviewClient;

    public  List<JobWithComp> getAllJobs() {

        List<Jobs> all = jobsRepository.findAll();
        List<JobWithComp> sd=new ArrayList<>();

        return   all.stream().map(this::convertTODTO).collect(Collectors.toList());

    }
        private  JobWithComp  convertTODTO(Jobs jobs){
//        System.out.println(jobs.getId());
            JobWithComp job=new JobWithComp();
            Company forObject =    companyRef.getCompaniesByID(jobs.getCompanyId());
            job.setDescs(forObject.getDescs());
            job.setName(forObject.getName());
            job.setId(forObject.getId());
            job.setJobs(jobs);

            List<Review> reviewById = reviewClient.getAllReview (jobs.getId());

            job.setReview(reviewById);
            return  job;
        }



    // Get job by ID
    public Optional<Jobs> getJobById(int id) {
        Optional<Jobs> byId = jobsRepository.findById(id);
        Company companiesByID = companyRef.getCompaniesByID(byId.get().getCompanyId());
        List<Review> allReview = reviewClient.getAllReview(byId.get().getCompanyId());
    return  byId;
    }
    // Save a new job
    public Jobs saveJob(Jobs job) {
        return jobsRepository.save(job);
    }

    // Update an existing job
        public Jobs updateJob(int id, Jobs updatedJob) {
            // Find the existing job
            Jobs existingJob = jobsRepository.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));

            // Update all fields from the provided job
            existingJob.setTitle(updatedJob.getTitle());
            existingJob.setDescription(updatedJob.getDescription());
            existingJob.setMinsalary(updatedJob.getMinsalary());
            existingJob.setMaxsalary(updatedJob.getMaxsalary());
            existingJob.setLocation(updatedJob.getLocation());

            // Save the updated job back to the repository
            return jobsRepository.save(existingJob);
        }

    public boolean existsById(int id) {
        return jobsRepository.existsById(id);
    }
    // Delete a job by ID
    public void deleteJob(int id) {
        jobsRepository.deleteById(id);
    }


}
