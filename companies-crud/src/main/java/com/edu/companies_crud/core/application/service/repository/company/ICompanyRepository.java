package com.edu.companies_crud.core.application.service.repository.company;

import com.edu.companies_crud.core.domain.model.company.Company;

import java.util.List;
import java.util.Optional;

public interface ICompanyRepository {
    List<Company> findAll();
    Optional<Company> findById(Long companyId);
    Optional<Company> findByName(String name);
    Company save(Company company);
    void deleteById(Long companyId);
}
