package com.edu.companies_crud.core.application.usecase.company.createCompany;

import com.edu.companies_crud.core.domain.model.website.WebSite;

import java.time.LocalDate;
import java.util.List;

public record CreateCompanyRequest(
        String name,
        String founder,
        String logo,
        LocalDate foundationDate,
        List<WebSite> webSites
) {
}
