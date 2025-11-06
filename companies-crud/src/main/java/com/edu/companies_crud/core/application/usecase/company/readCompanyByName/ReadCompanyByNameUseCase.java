package com.edu.companies_crud.core.application.usecase.company.readCompanyByName;

import com.edu.companies_crud.core.application.mapper.company.CompanyMapper;
import com.edu.companies_crud.core.application.service.repository.company.ICompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class ReadCompanyByNameUseCase implements IReadCompanyByNameUseCase{

    private final ICompanyRepository companyRepository;

    public ReadCompanyByNameUseCase(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ReadCompanyByNameResponse execute(String name) {
        return companyRepository.findByName(name)
                .map(CompanyMapper::toReadCompanyByNameResponse)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
    }
}
