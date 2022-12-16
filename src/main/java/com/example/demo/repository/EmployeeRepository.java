package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.repository.ListCrudRepository;

public interface EmployeeRepository extends ListCrudRepository<Employee, Long> {
}
