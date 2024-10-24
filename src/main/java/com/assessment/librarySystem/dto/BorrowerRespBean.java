package com.assessment.librarySystem.dto;

public class BorrowerRespBean {
    private Long borrowerId;
    private String borrowerName;
    private String borrowerEmail;
	public Long getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(Long borrowerId) {
		this.borrowerId = borrowerId;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getBorrowerEmail() {
		return borrowerEmail;
	}
	public void setBorrowerEmail(String borrowerEmail) {
		this.borrowerEmail = borrowerEmail;
	}
}
