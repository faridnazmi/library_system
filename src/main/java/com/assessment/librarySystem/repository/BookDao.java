package com.assessment.librarySystem.repository;

import com.assessment.librarySystem.entity.BookEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<BookEntity, Long> {
	 boolean existsByBookId(Long bookId);
    // Custom methods for finding books by ISBN if needed
}
