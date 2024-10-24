package com.assessment.librarySystem.repository;

import com.assessment.librarySystem.entity.BorrowRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowRecordDao extends JpaRepository<BorrowRecordEntity, Long> {
    Optional<BorrowRecordEntity> findByBookIdAndBorrowerId(Long bookId, Long borrowerId);
}
