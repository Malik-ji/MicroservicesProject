package com.malikas.jobms;

import com.malikas.jobms.entity.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient( name = "COMPANYMS")
public interface CompanyRef {
    @GetMapping
    public List<Company> getAllCompanies();
    @GetMapping("/companies/{id}")
    public Company getCompaniesByID(@PathVariable int id);
}
