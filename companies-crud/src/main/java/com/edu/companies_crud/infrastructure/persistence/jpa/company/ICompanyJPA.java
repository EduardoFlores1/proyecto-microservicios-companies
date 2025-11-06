package com.edu.companies_crud.infrastructure.persistence.jpa.company;

import com.edu.companies_crud.infrastructure.persistence.entity.company.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICompanyJPA extends JpaRepository<CompanyEntity, Long> {
        Optional<CompanyEntity> findByName(String name);
}
