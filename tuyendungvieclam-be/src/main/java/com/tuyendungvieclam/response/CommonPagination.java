package com.tuyendungvieclam.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonPagination {
	
	@JsonProperty("page_number")
	private int pageNumber;
	
	@JsonProperty("page_size")
	private int pageSize;
	
	@JsonProperty("total_page")
	private int totalPage;
	
	@JsonProperty("total_item")
	private long totalItem;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(long totalItem) {
		this.totalItem = totalItem;
	}

	public CommonPagination(int pageNumber, int pageSize, int totalPage, long totalItem) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalItem = totalItem;
	}
}
