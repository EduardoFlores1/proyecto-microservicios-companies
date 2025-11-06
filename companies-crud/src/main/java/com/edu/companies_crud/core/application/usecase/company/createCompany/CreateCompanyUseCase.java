package com.edu.companies_crud.core.application.usecase.company.createCompany;

import com.edu.companies_crud.core.application.mapper.company.CompanyMapper;
import com.edu.companies_crud.core.application.service.repository.company.ICompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCompanyUseCase implements ICreateCompanyUseCase{

    private final ICompanyRepository companyRepository;

    public CreateCompanyUseCase(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional
    public CreateCompanyResponse execute(CreateCompanyRequest request) {
        return CompanyMapper.toCreateCompanyResponse(
                companyRepository.save(CompanyMapper.fromCreateCompanyRequest(request))
        );

    }
}
