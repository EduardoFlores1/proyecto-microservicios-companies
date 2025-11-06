package com.edu.companies_crud.api.controller.company;

import com.edu.companies_crud.core.application.usecase.company.deleteCompanyByName.IDeleteCompanyUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/companies")
@Slf4j
@Tag(name = "Company Resources")
public class DeleteCompanyByNameController {

    private final IDeleteCompanyUseCase deleteCompanyUseCase;

    public DeleteCompanyByNameController(IDeleteCompanyUseCase deleteCompanyUseCase) {
        this.deleteCompanyUseCase = deleteCompanyUseCase;
    }

    @Operation(summary = "delete by name")
    @DeleteMapping("delete/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        log.info("DELETE: delete company {}", name);
        deleteCompanyUseCase.execute(name);
        return ResponseEntity.noContent().build();
    }
}
