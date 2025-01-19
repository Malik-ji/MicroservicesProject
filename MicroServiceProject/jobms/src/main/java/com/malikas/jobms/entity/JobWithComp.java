package com.malikas.jobms.entity;


import com.malikas.jobms.controller.Review;

import java.io.Serializable;
import java.util.List;

public class JobWithComp implements Serializable {

    public Jobs jobs;
    int Id;
    String name;
    String descs;
    List<Review> review;

    public Jobs getJobs() {
        return jobs;
    }

    public JobWithComp setJobs(Jobs jobs) {
        this.jobs = jobs;
        return this;
    }

    public int getId() {
        return Id;
    }

    public JobWithComp setId(int id) {
        Id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JobWithComp setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescs() {
        return descs;
    }

    public JobWithComp setDescs(String descs) {
        this.descs = descs;
        return this;
    }

    public List<Review> getReview() {
        return review;
    }

    public JobWithComp setReview(List<Review> review) {
        this.review = review;
        return this;
    }
}
