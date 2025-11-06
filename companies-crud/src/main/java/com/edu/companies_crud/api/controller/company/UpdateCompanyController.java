package com.edu.companies_crud.api.controller.company;

import com.edu.companies_crud.core.application.usecase.company.updateCompany.IUpdateCompanyUseCase;
import com.edu.companies_crud.core.application.usecase.company.updateCompany.UpdateCompanyRequest;
import com.edu.companies_crud.core.application.usecase.company.updateCompany.UpdateCompanyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/companies")
@Slf4j
@Tag(name = "Company Resources")
public class UpdateCompanyController {

    private final IUpdateCompanyUseCase updateCompanyUseCase;

    public UpdateCompanyController(IUpdateCompanyUseCase updateCompanyUseCase) {
        this.updateCompanyUseCase = updateCompanyUseCase;
    }

    @Operation(summary = "update company")
    @PutMapping("update/{name}")
    public ResponseEntity<UpdateCompanyResponse> update(
            @PathVariable String name,
            @RequestBody UpdateCompanyRequest request
            ) {
        log.info("PUT: update company {}", name);
        return ResponseEntity.ok(updateCompanyUseCase.execute(name, request));
    }
}
