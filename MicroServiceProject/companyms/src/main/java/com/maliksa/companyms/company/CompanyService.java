package com.maliksa.companyms.company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    List<Company> getAllCompanies();
    Boolean updateCompany(Company company,int id);
    boolean  updatJob(int id,Company updatedComp);
    boolean deleteCompanyById(int id);
    void createCompany(Company company);
    Company getCompanyById(int id);


}
