package com.edu.report_ms.core.application.usecase.company.deleteReportByName;

import com.edu.report_ms.core.application.service.repository.ICompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteReportByNameUseCase implements IDeleteReportByNameUseCase{

    private final ICompanyRepository companyRepository;

    @Override
    public void execute(String companyName) {
        this.companyRepository.deleteByName(companyName);
    }
}
