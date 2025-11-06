package com.edu.companies_crud.core.domain.model.company;

import com.edu.companies_crud.core.domain.model.website.WebSite;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Company {
    private Long id;
    private String name;
    private String founder;
    private String logo;
    private LocalDate foundationDate;
    private List<WebSite> webSites;

    public Company() {}

    public Company(Long id, String name, String founder, String logo, LocalDate foundationDate, List<WebSite> webSites) {
        this.id = id;
        this.name = name;
        this.founder = founder;
        this.logo = logo;
        this.foundationDate = foundationDate;
        this.webSites = webSites;
    }

    public Company(String name, String founder, String logo, LocalDate foundationDate, List<WebSite> webSites) {
        this.name = name;
        this.founder = founder;
        this.logo = logo;
        this.foundationDate = foundationDate;
        this.webSites = webSites;
    }
}
