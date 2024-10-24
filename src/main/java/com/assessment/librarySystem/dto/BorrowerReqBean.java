package com.assessment.librarySystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class BorrowerReqBean {
    @NotBlank(message = "Name is required")
    private String borrowerName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String borrowerEmail;

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

    
    // Getters and Setters
}
