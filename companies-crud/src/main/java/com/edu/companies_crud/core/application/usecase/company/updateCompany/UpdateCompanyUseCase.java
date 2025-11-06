package com.edu.companies_crud.core.application.usecase.company.updateCompany;

import com.edu.companies_crud.core.application.mapper.company.CompanyMapper;
import com.edu.companies_crud.core.application.service.repository.company.ICompanyRepository;
import com.edu.companies_crud.core.domain.model.company.Company;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class UpdateCompanyUseCase implements IUpdateCompanyUseCase{

    private final ICompanyRepository companyRepository;

    public UpdateCompanyUseCase(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional
    public UpdateCompanyResponse execute(String name, UpdateCompanyRequest request) {
        return companyRepository.findByName(name)
                .map(company -> applyUpdate(company, request))
                .map(updated -> CompanyMapper.
                        toUpdateCompanyResponse(companyRepository.save(updated)))
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
    }

    private Company applyUpdate(Company company, UpdateCompanyRequest request) {
        company.setLogo(request.logo());
        company.setFounder(request.founder());
        company.setFoundationDate(request.foundationDate());
        return company;
    }
}
