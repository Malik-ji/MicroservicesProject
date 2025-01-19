package com.malikas.jobms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class Company implements  Serializable {

    int Id;
    String name;

    String descs;


    public String getDescs() {
        return descs;
    }

    public int getId() {

        return Id;
    }

    public Company setId(int id) {
        Id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return descs;
    }

    public Company setDescs(String descs) {
        this.descs = descs;
        return this;
    }


    @Override
    public String toString() {
        return "Company{" +
                "Id=" + Id +
                ", name='" + name + '\'' +

                ", descs='" + descs + '\'' +
                 +
                '}';
    }
}
