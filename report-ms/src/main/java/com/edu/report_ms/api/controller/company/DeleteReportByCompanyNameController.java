package com.edu.report_ms.api.controller.company;

import com.edu.report_ms.core.application.usecase.company.deleteReportByName.IDeleteReportByNameUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/companies")
public class DeleteReportByCompanyNameController {

    private final IDeleteReportByNameUseCase deleteReportByNameUseCase;

    public DeleteReportByCompanyNameController(IDeleteReportByNameUseCase deleteReportByNameUseCase) {
        this.deleteReportByNameUseCase = deleteReportByNameUseCase;
    }

    @DeleteMapping("delete/{name}")
    public ResponseEntity<Void> deleteByName(@PathVariable String name) {
        this.deleteReportByNameUseCase.execute(name);
        return ResponseEntity.noContent().build();
    }
}
