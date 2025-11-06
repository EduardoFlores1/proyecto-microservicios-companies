package com.edu.companies_crud.infrastructure.persistence.jpa.website;

import com.edu.companies_crud.infrastructure.persistence.entity.website.WebSiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWebSiteJPA extends JpaRepository<WebSiteEntity, Long> {
}
