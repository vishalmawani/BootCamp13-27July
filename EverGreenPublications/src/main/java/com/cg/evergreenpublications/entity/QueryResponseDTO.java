package com.cg.evergreenpublications.entity;

import java.util.List;

public class QueryResponseDTO {

	 private List<CustomerInformation> list;
	 private long totalNoOfPages;
	 private long currentPageNumber;
	public List<CustomerInformation> getList() {
		return list;
	}
	public void setList(List<CustomerInformation> list) {
		this.list = list;
	}
	public long getTotalNoOfPages() {
		return totalNoOfPages;
	}
	public void setTotalNoOfPages(long totalNoOfPages) {
		this.totalNoOfPages = totalNoOfPages;
	}
	public long getCurrentPageNumber() {
		return currentPageNumber;
	}
	public void setCurrentPageNumber(long currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	 
	
	 
}