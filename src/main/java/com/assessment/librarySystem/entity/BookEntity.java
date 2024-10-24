package com.assessment.librarySystem.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "book", catalog = "public", schema = "public")
public class BookEntity implements Serializable {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "book_isbn_no")
    private String bookIsbnNo;

    @Column(name = "book_title", length = 200)
    private String bookTitle;
    
    @Column(name = "book_author", length = 200)
    private String bookAuthor;
    
    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = true)  // Nullable when the book is not borrowed
    private BorrowerEntity borrower;  // Link to the borrower who has the book

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "borrowed_at")
    private Date borrowedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "returned_at")
    private Date returnedAt;
    
    

	public BorrowerEntity getBorrower() {
		return borrower;
	}

	public void setBorrower(BorrowerEntity borrower) {
		this.borrower = borrower;
	}

	public Date getBorrowedAt() {
		return borrowedAt;
	}

	public void setBorrowedAt(Date borrowedAt) {
		this.borrowedAt = borrowedAt;
	}

	public Date getReturnedAt() {
		return returnedAt;
	}

	public void setReturnedAt(Date returnedAt) {
		this.returnedAt = returnedAt;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookIsbnNo() {
		return bookIsbnNo;
	}

	public void setBookIsbnNo(String bookIsbnNo) {
		this.bookIsbnNo = bookIsbnNo;
	}


	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

}
