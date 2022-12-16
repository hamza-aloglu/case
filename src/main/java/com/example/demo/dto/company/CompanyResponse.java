package com.example.demo.dto.company;

import com.example.demo.model.Employee;

import java.time.LocalDate;
import java.util.List;

public class CompanyResponse extends CompanyDto{
    private Long id;
    private List<Employee> employees;

    public CompanyResponse(Long id, String name, LocalDate foundationDate, List<Employee> employees) {
        super(name, foundationDate);
        this.id = id;
        this.employees = employees;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
