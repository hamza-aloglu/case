package com.example.demo.dto.company;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CompanyDto {
    @NotBlank
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate foundationDate;

    public CompanyDto(String name, LocalDate foundationDate) {
        this.name = name;
        this.foundationDate = foundationDate;
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
}
