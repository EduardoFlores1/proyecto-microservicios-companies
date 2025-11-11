package com.edu.report_ms.core.application.usecase.company.saveReportByName;

import com.edu.report_ms.core.domain.model.website.WebSite;

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
