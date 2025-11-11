package com.edu.companies_crud.infrastructure.persistence.mapper.website;

import com.edu.companies_crud.core.domain.model.website.WebSite;
import com.edu.companies_crud.infrastructure.persistence.entity.website.WebSiteEntity;

public class WebSiteMapperInfra {
    public static WebSite toDomain(WebSiteEntity entity) {
        return new WebSite(
                entity.getId(),
                entity.getName(),
                entity.getCategory(),
                entity.getDescription());
    }

    public static WebSiteEntity toEntity(WebSite domain) {
        return new WebSiteEntity(
                domain.getId(),
                domain.getName(),
                domain.getCategory(),
                domain.getDescription());
    }
}
