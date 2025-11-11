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

    public WebSite(Long id, String name, Category category, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
    }
}
