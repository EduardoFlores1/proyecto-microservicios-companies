package com.edu.companies_crud.api.controller.company;

import com.edu.companies_crud.core.application.usecase.company.createCompany.CreateCompanyRequest;
import com.edu.companies_crud.core.application.usecase.company.createCompany.CreateCompanyResponse;
import com.edu.companies_crud.core.application.usecase.company.createCompany.ICreateCompanyUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(path = "/api/v1/companies")
@Slf4j
@Tag(name = "Company Resources")
public class CreateCompanyController {

    private final ICreateCompanyUseCase createCompanyUseCase;

    public CreateCompanyController(ICreateCompanyUseCase createCompanyUseCase) {
        this.createCompanyUseCase = createCompanyUseCase;
    }

    @Operation(summary = "create company")
    @PostMapping("create")
    public ResponseEntity<CreateCompanyResponse> create(@RequestBody CreateCompanyRequest request) {
        log.info("POST: create company {}", request.name());
        return ResponseEntity.created(URI.create(request.name()))
                .body(createCompanyUseCase.execute(request));
    }
}
