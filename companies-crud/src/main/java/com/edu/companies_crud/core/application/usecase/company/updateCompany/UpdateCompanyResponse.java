package com.edu.companies_crud.core.application.usecase.company.updateCompany;

import com.edu.companies_crud.core.domain.model.website.WebSite;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record UpdateCompanyResponse(
        Long id,
        String name,
        String founder,
        String logo,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate foundationDate,
        List<WebSite> webSites
) {
}
