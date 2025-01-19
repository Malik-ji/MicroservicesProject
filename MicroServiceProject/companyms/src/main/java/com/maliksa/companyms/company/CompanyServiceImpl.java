package com.maliksa.companyms.company;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    CompanyRepository companyRepository;
    public CompanyServiceImpl(CompanyRepository companyRepository)
    {
        this.companyRepository=companyRepository;
    }
    @Override
    public List<Company> getAllCompanies() {

        return companyRepository.findAll();
    }

    @Override
    public Boolean updateCompany(Company company, int id) {
        Optional<Company> byId = companyRepository.findById(id);
            if(byId.isPresent())
            {
                Company test=byId.get();
                test.setDescs(company.getDesc());
                test.setName(company.getName());
//                test.setJobs(company.getJobs());?
                companyRepository.save(test);
                return true;
            }
        return false;

    }

    @Override
    public boolean updatJob(int id, Company updatedComp) {
        return false;
    }

    @Override
    public boolean deleteCompanyById(int id) {
        if(companyRepository.existsById(id))
        {
            companyRepository.deleteById(id);
            return  true;
        }else {
            return  false;
        }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(int id) {
        return companyRepository.findById(id).get();
    }

    public Company saveCompany(Company company)
    {
        companyRepository.save(company);
        return  company;
    }
}
