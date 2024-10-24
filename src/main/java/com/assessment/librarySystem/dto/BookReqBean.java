package com.assessment.librarySystem.dto;

import jakarta.validation.constraints.NotBlank;

public class BookReqBean{
    @NotBlank(message = "ISBN is required")
    private String bookIsbnNo;

    @NotBlank(message = "Title is required")
    private String bookTitle;

    @NotBlank(message = "Author is required")
    private String bookAuthor;

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
