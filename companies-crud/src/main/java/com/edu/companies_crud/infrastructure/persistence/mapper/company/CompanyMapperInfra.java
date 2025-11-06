package com.edu.companies_crud.infrastructure.persistence.mapper.company;

import com.edu.companies_crud.core.domain.model.company.Company;
import com.edu.companies_crud.infrastructure.persistence.entity.company.CompanyEntity;
import com.edu.companies_crud.infrastructure.persistence.mapper.website.WebSiteMapperInfra;

public class CompanyMapperInfra {
    public static Company toDomain(CompanyEntity entity) {
        return new Company(entity.getId(),
                entity.getName(),
                entity.getFounder(),
                entity.getLogo(),
                entity.getFoundationDate(),
                entity.getWebSites().stream().map(WebSiteMapperInfra::toDomain).toList());
    }

    public static CompanyEntity toEntity(Company domain) {
        return new CompanyEntity(domain.getId(),
                domain.getName(),
                domain.getFounder(),
                domain.getLogo(),
                domain.getFoundationDate(),
                domain.getWebSites().stream().map(WebSiteMapperInfra::toEntity).toList());
    }
}
