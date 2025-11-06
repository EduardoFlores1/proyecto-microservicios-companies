package com.edu.companies_crud.infrastructure.persistence.repository.company;

import com.edu.companies_crud.core.application.service.repository.company.ICompanyRepository;
import com.edu.companies_crud.core.domain.model.company.Company;
import com.edu.companies_crud.infrastructure.persistence.jpa.company.ICompanyJPA;
import com.edu.companies_crud.infrastructure.persistence.mapper.company.CompanyMapperInfra;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompanyRepository implements ICompanyRepository {

    private final ICompanyJPA companyJPA;

    public CompanyRepository(ICompanyJPA companyJPA) {
        this.companyJPA = companyJPA;
    }

    @Override
    public List<Company> findAll() {
        return companyJPA.findAll()
                .stream().map(CompanyMapperInfra::toDomain)
                .toList();
    }

    @Override
    public Optional<Company> findById(Long companyId) {
        return companyJPA.findById(companyId)
                .map(CompanyMapperInfra::toDomain);
    }

    @Override
    public Optional<Company> findByName(String name) {
        return companyJPA.findByName(name)
                .map(CompanyMapperInfra::toDomain);
    }

    @Override
    public Company save(Company company) {
        return CompanyMapperInfra.toDomain(
                companyJPA.save(CompanyMapperInfra.toEntity(company))
        );
    }

    @Override
    public void deleteById(Long companyId) {
        companyJPA.deleteById(companyId);
    }
}
