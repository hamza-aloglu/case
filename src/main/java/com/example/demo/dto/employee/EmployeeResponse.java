package com.example.demo.dto.employee;

import com.example.demo.enums.Tier;
import com.example.demo.model.Company;

import java.time.LocalDate;

public class EmployeeResponse extends EmployeeDto {
    private Long id;
    private Company company;

    public EmployeeResponse(Long id, String name, Tier tier, Long salary, LocalDate hireDate, Company company) {
        super(name, tier, salary, hireDate);
        this.company = company;
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
