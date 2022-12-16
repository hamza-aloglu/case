package com.example.demo.dto.employee;

import com.example.demo.enums.Tier;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class EmployeeDto {
    @NotBlank
    private String name;
    private Tier tier;
    private Long salary;

    private LocalDate hireDate;

    public EmployeeDto(String name, Tier tier, Long salary, LocalDate hireDate) {
        this.name = name;
        this.tier = tier;
        this.salary = salary;
        this.hireDate = hireDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
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
}
