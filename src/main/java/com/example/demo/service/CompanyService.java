package com.example.demo.service;

import com.example.demo.dto.company.CompanyRequest;
import com.example.demo.dto.company.CompanyResponse;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public Iterable<CompanyResponse> getAll() {
        List<CompanyResponse> companyResponses = new ArrayList<>();

        companyRepository.findAll().forEach(company -> companyResponses.add(new CompanyResponse(
                company.getId(),
                company.getName(),
                company.getFoundationDate(),
                company.getEmployees()
        )));

        return companyResponses;
    }

    public CompanyResponse get(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() ->  new NotFoundException("Company not found with id: " + id));

        return new CompanyResponse(
                company.getId(),
                company.getName(),
                company.getFoundationDate(),
                company.getEmployees()
        );
    }

    protected Company getCompany(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new NotFoundException("Company not found with id: " + id));
    }

    public CompanyResponse create(CompanyRequest companyRequest) {
        Company company = new Company(
                companyRequest.getName(),
                companyRequest.getFoundationDate(),
                new ArrayList<>()
        );
        companyRepository.save(company);

        return new CompanyResponse(
                company.getId(),
                company.getName(),
                company.getFoundationDate(),
                company.getEmployees()
        );
    }

    public CompanyResponse update(CompanyRequest companyRequest, Long id) {
        Company company = this.getCompany(id);

        company.setName(companyRequest.getName());
        company.setFoundationDate(companyRequest.getFoundationDate());

        companyRepository.save(company);

        return new CompanyResponse(
                company.getId(),
                company.getName(),
                company.getFoundationDate(),
                company.getEmployees()
        );
    }

    public void delete(Long id) {
        Company company = this.getCompany(id);
        companyRepository.delete(company);
    }
}
