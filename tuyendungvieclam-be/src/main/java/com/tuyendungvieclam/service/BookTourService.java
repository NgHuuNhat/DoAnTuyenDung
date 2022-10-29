package com.tuyendungvieclam.service;

import java.util.List;
import com.tuyendungvieclam.dto.BookTourDTO;
import com.tuyendungvieclam.request.admin.booktour.UpdateBookTourRequest;
import com.tuyendungvieclam.request.client.booktour.BookTourRequest;

public interface BookTourService {

	public BookTourDTO bookTour(BookTourRequest request);
	
	public List<BookTourDTO> getAllBookTour();
	
	public BookTourDTO findByID(String id);
	
	public BookTourDTO upDateBookTour(UpdateBookTourRequest request);

	public BookTourDTO deleteBookTour(String bookTourId);
}
