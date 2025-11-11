package com.edu.report_ms.core.application.usecase.company.saveReportByName;

import com.edu.report_ms.core.application.helper.ReportHelper;
import com.edu.report_ms.core.application.service.repository.ICompanyRepository;
import com.edu.report_ms.core.domain.model.website.WebSite;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@AllArgsConstructor
@Slf4j
@Service
public class SaveReportByTemplateUseCase implements ISaveReportByTemplateUseCase {

    private final ICompanyRepository companyRepository;
    private final ReportHelper reportHelper;

    @Override
    public String execute(String template) {

        var format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var placeHolders = reportHelper.getPlaceHoldersFromTemplate(template);
        var webSites = Stream.of(placeHolders.get(3))
                .map(WebSite::new)
                .toList();

        var request = new CreateCompanyRequest(
                placeHolders.get(0),
                placeHolders.get(2),
                "logo.png",
                LocalDate.parse(placeHolders.get(1), format),
                webSites
        );

        var result = companyRepository.postByName(request)
                .orElseThrow();

        return "saved: " + result.getName();
    }
}
