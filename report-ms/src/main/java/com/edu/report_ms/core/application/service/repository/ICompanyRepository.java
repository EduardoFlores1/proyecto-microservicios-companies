package com.edu.report_ms.core.application.service.repository;

import com.edu.report_ms.core.application.usecase.company.saveReportByName.CreateCompanyRequest;
import com.edu.report_ms.core.domain.model.company.Company;

import java.util.Optional;

public interface ICompanyRepository {

    Optional<Company> getByName(String name);
    Optional<Company> postByName(CreateCompanyRequest request);
    void deleteByName(String name);
}
