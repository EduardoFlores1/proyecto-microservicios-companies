package com.edu.companies_crud.core.application.service.repository.website;

import com.edu.companies_crud.core.domain.model.website.WebSite;

import java.util.List;
import java.util.Optional;

public interface IWebSiteRepository {
    List<WebSite> findAll();
    Optional<WebSite> findById(Long webSiteId);
    void save(WebSite webSite);
}
