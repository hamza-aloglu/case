package com.example.demo.controller;

import com.example.demo.dto.employee.EmployeeRequest;
import com.example.demo.dto.employee.EmployeeResponse;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("employee")
    public Iterable<EmployeeResponse> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("employee/{id}")
    public EmployeeResponse get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @PostMapping("employee")
    public EmployeeResponse create(@Valid @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.create(employeeRequest);
    }

    @PutMapping("employee/{id}")
    public EmployeeResponse update(@Valid @RequestBody EmployeeRequest employeeRequest, @PathVariable Long id) {
        return employeeService.update(employeeRequest, id);
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
