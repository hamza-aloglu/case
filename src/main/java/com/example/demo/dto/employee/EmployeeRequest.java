package com.example.demo.dto.employee;

import com.example.demo.enums.Tier;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmployeeRequest extends EmployeeDto {

    @NotNull
    private Long companyId;

    public EmployeeRequest(String name, Tier tier, Long salary, LocalDate hireDate, Long companyId) {
        super(name, tier, salary, hireDate);
        this.companyId = companyId;
    }


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
