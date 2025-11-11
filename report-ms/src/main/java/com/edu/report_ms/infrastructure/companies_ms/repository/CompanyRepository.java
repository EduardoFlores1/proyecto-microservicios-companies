package com.edu.report_ms.infrastructure.companies_ms.repository;

import com.edu.report_ms.core.application.service.repository.ICompanyRepository;
import com.edu.report_ms.core.application.usecase.company.saveReportByName.CreateCompanyRequest;
import com.edu.report_ms.core.domain.model.company.Company;
import com.edu.report_ms.infrastructure.companies_ms.feign.ICompanyFeign;
import com.edu.report_ms.infrastructure.companies_ms.mapper.CompanyMapperFeign;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyRepository implements ICompanyRepository {

    private final ICompanyFeign companyFeign;

    public CompanyRepository(ICompanyFeign companyFeign) {
        this.companyFeign = companyFeign;
    }

    public Optional<Company> getByName(String name) {
        return companyFeign.getByName(name)
                .map(CompanyMapperFeign::fromGetByName);
    }

    public Optional<Company> postByName(CreateCompanyRequest request) {
        return companyFeign.postByName(request)
                .map(CompanyMapperFeign::fromPostByName);
    };

    public void deleteByName(String name) {
        companyFeign.deleteByName(name);
    }
}
