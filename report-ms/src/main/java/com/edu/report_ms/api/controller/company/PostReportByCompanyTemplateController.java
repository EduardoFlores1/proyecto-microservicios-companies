package com.edu.report_ms.api.controller.company;

import com.edu.report_ms.core.application.usecase.company.saveReportByName.ISaveReportByTemplateUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/companies")
public class PostReportByCompanyTemplateController {

    private final ISaveReportByTemplateUseCase saveReportByTemplateUseCase;

    public PostReportByCompanyTemplateController(ISaveReportByTemplateUseCase saveReportByTemplateUseCase) {
        this.saveReportByTemplateUseCase = saveReportByTemplateUseCase;
    }

    @PostMapping("create")
    public ResponseEntity<String> saveReport(
            @RequestBody String template) {
        var response = this.saveReportByTemplateUseCase.execute(template);
        return ResponseEntity.ok(response);
    }
}
