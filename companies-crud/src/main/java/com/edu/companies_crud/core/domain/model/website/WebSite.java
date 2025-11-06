package com.edu.companies_crud.core.domain.model.website;

import com.edu.companies_crud.core.domain.enums.Category;
import lombok.Data;

@Data
public class WebSite {
    private Long id;
    private String name;
    private Category category;
    private String description;

    public WebSite() {}

    public WebSite(Long id, String description, Category category, String name) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.name = name;
    }
}
