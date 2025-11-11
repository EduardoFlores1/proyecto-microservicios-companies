package com.edu.report_ms.infrastructure.companies_ms.feign;

import com.edu.report_ms.infrastructure.beans.LoadBalancerConfiguration;
import com.edu.report_ms.infrastructure.companies_ms.model.readCompany.ReadCompanyByNameResponse;
import com.edu.report_ms.core.application.usecase.company.saveReportByName.CreateCompanyRequest;
import com.edu.report_ms.infrastructure.companies_ms.model.saveCompany.CreateCompanyResponse;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "companies-crud")
@LoadBalancerClient(name = "companies-crud", configuration = LoadBalancerConfiguration.class)
public interface ICompanyFeign {

    @GetMapping("/companies-crud/api/v1/companies/read-by-name/{name}")
    Optional<ReadCompanyByNameResponse> getByName(@PathVariable String name);

    @PostMapping("/companies-crud/api/v1/companies/create")
    Optional<CreateCompanyResponse> postByName(@RequestBody CreateCompanyRequest request);

    @DeleteMapping("/companies-crud/api/v1/companies/delete/{name}")
    void deleteByName(@PathVariable String name);
}
