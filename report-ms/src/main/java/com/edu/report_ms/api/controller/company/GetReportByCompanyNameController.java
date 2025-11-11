package com.edu.report_ms.api.controller.company;

import com.edu.report_ms.core.application.usecase.company.makeReportByName.IMakeReportByNameUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/companies")
public class GetReportByCompanyNameController {

    private final IMakeReportByNameUseCase makeReportByNameUseCase;

    public GetReportByCompanyNameController(IMakeReportByNameUseCase makeReportByNameUseCase) {
        this.makeReportByNameUseCase = makeReportByNameUseCase;
    }

    @GetMapping("get-report/{companyName}")
    public ResponseEntity<Map<String, String>> getReport(
            @PathVariable String companyName) {
        var response = Map.of("Report", this.makeReportByNameUseCase.execute(companyName));
        return ResponseEntity.ok(response);
    }
}
