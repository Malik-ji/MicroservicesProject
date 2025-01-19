package com.malikas.jobms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
@Entity
public class Jobs implements Serializable {
    @Id
            
    int id;

    String title;
    String description;
    String minsalary;
    String maxsalary;
    String location;



    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;

    }

    private int companyId;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", minsalary='" + minsalary + '\'' +
                ", maxsalary='" + maxsalary + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public Jobs setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Jobs setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Jobs setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMinsalary() {
        return minsalary;
    }

    public Jobs setMinsalary(String minsalary) {
        this.minsalary = minsalary;
        return this;
    }

    public String getMaxsalary() {
        return maxsalary;
    }

    public Jobs setMaxsalary(String maxsalary) {
        this.maxsalary = maxsalary;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Jobs setLocation(String location) {
        this.location = location;
        return this;
    }
}
