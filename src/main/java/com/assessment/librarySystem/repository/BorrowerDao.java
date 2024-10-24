package com.assessment.librarySystem.repository;

import com.assessment.librarySystem.entity.BorrowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerDao extends JpaRepository<BorrowerEntity, Long> {
    // Custom methods for finding borrowers by email if needed
}
