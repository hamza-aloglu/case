package com.example.demo.controller;

import com.example.demo.dto.company.CompanyRequest;
import com.example.demo.dto.company.CompanyResponse;
import com.example.demo.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("company")
    public Iterable<CompanyResponse> getAll() {
        return companyService.getAll();
    }

    @GetMapping("company/{id}")
    public CompanyResponse get(@PathVariable Long id) {
        return companyService.get(id);
    }

    @PostMapping("company")
    public ResponseEntity<CompanyResponse> create(@Valid @RequestBody CompanyRequest companyRequest) {
        return new ResponseEntity<>(companyService.create(companyRequest), HttpStatus.CREATED);
    }

    @PutMapping("company/{id}")
    public CompanyResponse update(@Valid @RequestBody CompanyRequest companyRequest, @PathVariable Long id) {
        return companyService.update(companyRequest, id);
    }

    @DeleteMapping("company/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        companyService.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
