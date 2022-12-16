package com.example.demo.service;

import com.example.demo.dto.employee.EmployeeRequest;
import com.example.demo.dto.employee.EmployeeResponse;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;

    public EmployeeService(EmployeeRepository employeeRepository, CompanyService companyService) {
        this.employeeRepository = employeeRepository;
        this.companyService = companyService;
    }


    public Iterable<EmployeeResponse> getAll() {
        List<EmployeeResponse> employeeResponses = new ArrayList<>();

        employeeRepository.findAll().forEach(employee -> employeeResponses.add(new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getTier(),
                employee.getSalary(),
                employee.getHireDate(),
                employee.getCompany()
        )));

        return employeeResponses;
    }

    public EmployeeResponse get(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found with id: " + id) );

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getTier(),
                employee.getSalary(),
                employee.getHireDate(),
                employee.getCompany()
        );
    }

    protected Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
    }

    public EmployeeResponse create(EmployeeRequest employeeRequest) {
        Employee employee =  new Employee(
                employeeRequest.getName(),
                employeeRequest.getTier(),
                employeeRequest.getSalary(),
                employeeRequest.getHireDate(),
                companyService.getCompany(employeeRequest.getCompanyId())
        );
        employeeRepository.save(employee);

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getTier(),
                employee.getSalary(),
                employee.getHireDate(),
                employee.getCompany()
        );
    }

    public EmployeeResponse update(EmployeeRequest employeeRequest, Long id) {
        Employee employee = this.getEmployee(id);
        Company company = companyService.getCompany(id);

        employee.setName(employeeRequest.getName());
        employee.setTier(employeeRequest.getTier());
        employee.setSalary(employeeRequest.getSalary());
        employee.setHireDate(employeeRequest.getHireDate());
        employee.setCompany(company);

        employeeRepository.save(employee);

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getTier(),
                employee.getSalary(),
                employee.getHireDate(),
                employee.getCompany()
        );
    }

    public void delete(Long id) {
        Employee employee = this.getEmployee(id);
        employeeRepository.delete(employee);
    }

}
