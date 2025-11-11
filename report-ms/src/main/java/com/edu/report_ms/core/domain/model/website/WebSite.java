package com.edu.report_ms.core.domain.model.website;

import lombok.Data;

@Data
public class WebSite {

    private String name;

    public WebSite() {}

    public WebSite(String name) {
        this.name = name;
    }
}
