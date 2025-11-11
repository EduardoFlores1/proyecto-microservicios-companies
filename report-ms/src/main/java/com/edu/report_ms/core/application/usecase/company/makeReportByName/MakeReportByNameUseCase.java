package com.edu.report_ms.core.application.usecase.company.makeReportByName;

import com.edu.report_ms.core.application.helper.ReportHelper;
import com.edu.report_ms.core.application.service.repository.ICompanyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class MakeReportByNameUseCase implements IMakeReportByNameUseCase{

    private final ICompanyRepository companyRepository;
    private final ReportHelper reportHelper;

    @Override
    public String execute(String companyName) {
        return reportHelper.readTemplate(
                companyRepository.getByName(companyName)
                .orElseThrow()
        );
    }
}
