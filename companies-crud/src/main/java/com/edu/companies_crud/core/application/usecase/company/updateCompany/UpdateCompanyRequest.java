package com.edu.companies_crud.core.application.usecase.company.updateCompany;

import java.time.LocalDate;

public record UpdateCompanyRequest(
        String logo,
        String founder,
        LocalDate foundationDate
) {
}
