package com.assessment.librarySystem.dto;

public class BookRespBean {
    private Long bookId;
    private String bookIsbnNo;
    private String bookTitle;
    private String bookAuthor;
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
