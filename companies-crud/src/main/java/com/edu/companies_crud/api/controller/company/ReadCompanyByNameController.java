package com.edu.companies_crud.api.controller.company;

import com.edu.companies_crud.core.application.usecase.company.readCompanyByName.IReadCompanyByNameUseCase;
import com.edu.companies_crud.core.application.usecase.company.readCompanyByName.ReadCompanyByNameResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/companies")
@Slf4j
@Tag(name = "Company Resources")
public class ReadCompanyByNameController {

    private final IReadCompanyByNameUseCase readCompanyByNameUseCase;

    public ReadCompanyByNameController(IReadCompanyByNameUseCase readCompanyByNameUseCase) {
        this.readCompanyByNameUseCase = readCompanyByNameUseCase;
    }

    @Operation(summary = "read by name")
    @GetMapping("read-by-name/{name}")
    public ResponseEntity<ReadCompanyByNameResponse> read(@PathVariable String name) {
        log.info("GET: read company {}", name);
        return ResponseEntity.ok(readCompanyByNameUseCase.execute(name));
    }
}
