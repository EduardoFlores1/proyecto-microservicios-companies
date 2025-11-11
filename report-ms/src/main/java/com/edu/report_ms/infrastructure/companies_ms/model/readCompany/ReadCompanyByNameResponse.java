package com.edu.report_ms.infrastructure.companies_ms.model.readCompany;

import com.edu.report_ms.core.domain.model.website.WebSite;

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
