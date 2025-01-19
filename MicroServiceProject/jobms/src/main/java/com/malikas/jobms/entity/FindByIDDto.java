package com.malikas.jobms.entity;

import com.malikas.jobms.controller.Review;

import java.util.List;

public class FindByIDDto {
    private List<Review> review;
    private  Company company;

    private Jobs jobs;

    public List<Review> getReview() {
        return review;
    }

    public FindByIDDto setReview(List<Review> review) {
        this.review = review;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public FindByIDDto setCompany(Company company) {
        this.company = company;
        return this;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public FindByIDDto setJobs(Jobs jobs) {
        this.jobs = jobs;
        return this;
    }

    @Override
    public String toString() {
        return "FindByIDDto{" +
                "review=" + review +
                ", company=" + company +
                ", jobs=" + jobs +
                '}';
    }
}
