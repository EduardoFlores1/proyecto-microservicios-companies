package com.edu.companies_crud.infrastructure.persistence.entity.website;

import com.edu.companies_crud.core.domain.enums.Category;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "web_site")
@Data
public class WebSiteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;
    private String description;

    public WebSiteEntity() {}

    public WebSiteEntity(Long id, String description, Category category, String name) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.name = name;
    }
}
