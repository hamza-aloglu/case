package com.example.demo.model;

import com.example.demo.enums.Tier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Employee extends BaseEntity {
    private String name;
    private Tier tier;
    private Long salary;
    private LocalDate hireDate;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnore
    private Company company;

    public Employee() {
    }

    public Employee(String name, Tier tier, Long salary, LocalDate hireDate, Company company) {
        this.name = name;
        this.tier = tier;
        this.salary = salary;
        this.hireDate = hireDate;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tier getRank() {
        return tier;
    }

    public void setRank(Tier tier) {
        this.tier = tier;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
