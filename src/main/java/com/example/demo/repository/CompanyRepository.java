package com.example.demo.repository;

import com.example.demo.model.Company;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends ListCrudRepository<Company, Long> {
}
