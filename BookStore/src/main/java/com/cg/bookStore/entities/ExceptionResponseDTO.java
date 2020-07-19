package com.cg.bookStore.entities;

import java.time.LocalDate;

public class ExceptionResponseDTO {

	public LocalDate dateOfQuery;
	   public String reason;
	   public String statusMessage;
	
	public ExceptionResponseDTO(LocalDate localDate,String reason, String statusMessage) {
		super();
		this.dateOfQuery = localDate;
		this.reason=reason;
		this.statusMessage = statusMessage;
	}
}
