package com.edu.companies_crud.core.application.usecase.company.readCompanyByName;

import com.edu.companies_crud.core.domain.model.website.WebSite;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record ReadCompanyByNameResponse(
        Long id,
        String name,
        String founder,
        String logo,
        LocalDate foundationDate,
        List<WebSite> webSites
) {
}
