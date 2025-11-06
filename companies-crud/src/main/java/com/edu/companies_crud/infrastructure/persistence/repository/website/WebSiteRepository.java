package com.edu.companies_crud.infrastructure.persistence.repository.website;

import com.edu.companies_crud.core.application.service.repository.website.IWebSiteRepository;
import com.edu.companies_crud.core.domain.model.website.WebSite;
import com.edu.companies_crud.infrastructure.persistence.jpa.website.IWebSiteJPA;
import com.edu.companies_crud.infrastructure.persistence.mapper.website.WebSiteMapperInfra;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WebSiteRepository implements IWebSiteRepository {

    private final IWebSiteJPA webSiteJPA;

    public WebSiteRepository(IWebSiteJPA webSiteJPA) {
        this.webSiteJPA = webSiteJPA;
    }

    @Override
    public List<WebSite> findAll() {
        return webSiteJPA.findAll()
                .stream().map(WebSiteMapperInfra::toDomain)
                .toList();
    }

    @Override
    public Optional<WebSite> findById(Long webSiteId) {
        return webSiteJPA.findById(webSiteId)
                .map(WebSiteMapperInfra::toDomain);
    }

    @Override
    public void save(WebSite webSite) {
        webSiteJPA.save(WebSiteMapperInfra.toEntity(webSite));
    }
}
