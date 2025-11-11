package com.edu.report_ms.infrastructure.companies_ms.model.saveCompany;

import com.edu.report_ms.core.domain.model.website.WebSite;

import java.time.LocalDate;
import java.util.List;

public record CreateCompanyResponse(
        Long id,
        String name,
        String founder,
        String logo,
        LocalDate foundationDate,
        List<WebSite> webSites
) {
}
