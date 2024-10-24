package com.assessment.librarySystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "borrow_record", schema = "public")
public class BorrowRecordEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "book_id")
    private Long bookId;
    
    @Column(name = "borrower_id") 
    private Long borrowerId;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false, insertable = false, updatable = false)
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false, insertable = false, updatable = false)
    private BorrowerEntity borrower;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public BorrowerEntity getBorrower() {
        return borrower;
    }

    public void setBorrower(BorrowerEntity borrower) {
        this.borrower = borrower;
    }

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(Long borrowerId) {
		this.borrowerId = borrowerId;
	}
    
}
