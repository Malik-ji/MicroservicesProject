package com.maliksa.reviewms.Review;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class Review implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String title;
    private  String description;
    private Double rating;
    private int companyId;

    public int getCompanyId() {
        return companyId;
    }

    public Review setCompanyId(int companyId) {
        this.companyId = companyId;
        return this;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", companyId=" + companyId +
                '}';
    }
    public int getId() {
        return id;
    }

    public Review setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Review setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Review setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public Review setRating(Double rating) {
        this.rating = rating;
        return this;
    }
}
