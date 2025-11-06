package com.edu.companies_crud.core.application.mapper.company;

import com.edu.companies_crud.core.application.usecase.company.createCompany.CreateCompanyRequest;
import com.edu.companies_crud.core.application.usecase.company.createCompany.CreateCompanyResponse;
import com.edu.companies_crud.core.application.usecase.company.readCompanyByName.ReadCompanyByNameResponse;
import com.edu.companies_crud.core.application.usecase.company.updateCompany.UpdateCompanyResponse;
import com.edu.companies_crud.core.domain.model.company.Company;

public class CompanyMapper {
    public static Company fromCreateCompanyRequest(CreateCompanyRequest request) {
        return new Company(request.name(),
                request.founder(),
                request.logo(),
                request.foundationDate(),
                request.webSites());
    }

    public static ReadCompanyByNameResponse toReadCompanyByNameResponse(Company domain) {
        return new ReadCompanyByNameResponse(
                domain.getId(),
                domain.getName(),
                domain.getFounder(),
                domain.getLogo(),
                domain.getFoundationDate(),
                domain.getWebSites()
        );
    }

    public static CreateCompanyResponse toCreateCompanyResponse(Company domain) {
        return new CreateCompanyResponse(
                domain.getId(),
                domain.getName(),
                domain.getFounder(),
                domain.getLogo(),
                domain.getFoundationDate(),
                domain.getWebSites()
        );
    }

    public static UpdateCompanyResponse toUpdateCompanyResponse(Company domain) {
        return new UpdateCompanyResponse(
                domain.getId(),
                domain.getName(),
                domain.getFounder(),
                domain.getLogo(),
                domain.getFoundationDate(),
                domain.getWebSites()
        );
    }
}
