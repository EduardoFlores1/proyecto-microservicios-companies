package com.edu.companies_crud.core.application.usecase.company.updateCompany;

public interface IUpdateCompanyUseCase {
    UpdateCompanyResponse execute(String name, UpdateCompanyRequest request);
}
