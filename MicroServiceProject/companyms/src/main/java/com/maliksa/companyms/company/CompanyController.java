package com.maliksa.companyms.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies()
    {
        return  companyService.getAllCompanies();
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable int id,@RequestBody Company company)
    {
            companyService.updateCompany(company,id);

        return new ResponseEntity<>("Company updated Successfully", HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> saveCompany(@RequestBody Company company)
    {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added SuccessFully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByCompanyById(@PathVariable int id)
    {
        if(companyService.deleteCompanyById(id))
        {
            return  new ResponseEntity<>("Company Successfully deleted",HttpStatus.OK);

        }else
        {
            return  new ResponseEntity<>("Company Not Deleted",HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable int id)
    {
        Company companyById = companyService.getCompanyById(id);
        return new ResponseEntity<>(companyById,HttpStatus.OK);
    }
}
