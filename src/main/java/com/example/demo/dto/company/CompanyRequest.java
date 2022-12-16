package com.example.demo.dto.company;

import java.time.LocalDate;

public class CompanyRequest extends CompanyDto{
    public CompanyRequest(String name, LocalDate foundationDate) {
        super(name, foundationDate);
    }
}
