package com.edu.report_ms.infrastructure.companies_ms.mapper;

import com.edu.report_ms.core.domain.model.company.Company;
import com.edu.report_ms.infrastructure.companies_ms.model.readCompany.ReadCompanyByNameResponse;
import com.edu.report_ms.infrastructure.companies_ms.model.saveCompany.CreateCompanyResponse;

public class CompanyMapperFeign {

    public static Company fromGetByName(ReadCompanyByNameResponse response) {
        return new Company(
                response.id(),
                response.name(),
                response.founder(),
                response.logo(),
                response.foundationDate(),
                response.webSites()
        );
    }

    public static Company fromPostByName(CreateCompanyResponse response) {
        return new Company(
                response.id(),
                response.name(),
                response.founder(),
                response.logo(),
                response.foundationDate(),
                response.webSites()
        );
    }
}
