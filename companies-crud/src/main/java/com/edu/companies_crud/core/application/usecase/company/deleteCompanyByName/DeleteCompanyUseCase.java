package com.edu.companies_crud.core.application.usecase.company.deleteCompanyByName;

import com.edu.companies_crud.core.application.service.repository.company.ICompanyRepository;
import com.edu.companies_crud.core.domain.model.company.Company;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class DeleteCompanyUseCase implements IDeleteCompanyUseCase{

    private final ICompanyRepository companyRepository;

    public DeleteCompanyUseCase(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional
    public void execute(String name) {
        Long id = companyRepository.findByName(name)
                .map(Company::getId)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
        companyRepository.deleteById(id);
    }
}
