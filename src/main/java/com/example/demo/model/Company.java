package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Company extends BaseEntity {
    private String name;
    private LocalDate foundationDate;
    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<Employee> employees;

    public Company() {

    }
    public Company(String name, LocalDate foundationDate, List<Employee> employees) {
        this.name = name;
        this.foundationDate = foundationDate;
        this.employees = employees;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
