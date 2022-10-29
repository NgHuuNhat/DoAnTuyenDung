package com.tuyendungvieclam.controller.admin.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tuyendungvieclam.common.Constants;
import com.tuyendungvieclam.dto.BookTourDTO;
import com.tuyendungvieclam.request.admin.booktour.UpdateBookTourRequest;
import com.tuyendungvieclam.response.CommonResponse;
import com.tuyendungvieclam.response.admin.booktour.GetAllBookTourResponse;
import com.tuyendungvieclam.service.BookTourService;


@RestController
public class AdminBookTourApi {
	
	@Autowired
	private BookTourService bookTourService;

	@GetMapping(value = "/api/booktour")
	public ResponseEntity<List<GetAllBookTourResponse>> getAllBookTour() {
		List<BookTourDTO> bookTourDTOs = bookTourService.getAllBookTour();
		List<GetAllBookTourResponse> result = new ArrayList<>();
		for (BookTourDTO dto : bookTourDTOs) {
			result.add(GetAllBookTourResponse.copy(dto));
		}
		return ResponseEntity.ok(result);
	}
	
	
	
	@PutMapping(value = "/api/booktour")
	public ResponseEntity<CommonResponse<String>> updateBookTour(@RequestBody UpdateBookTourRequest request) {
		BookTourDTO bookTourDTO = bookTourService.upDateBookTour(request);
		CommonResponse<String> response = new CommonResponse<>();
		if (bookTourDTO == null) {
			response.setMessage(Constants.FAIL);
			response.setData("Ban xoa khong thanh cong.");
			return ResponseEntity.ok(response);
		}
		response.setMessage(Constants.SUCCESS);
		response.setData("Ban xoa thanh cong");
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value = "/api/booktour/{book_tour_id}")
	public ResponseEntity<CommonResponse<String>> deleBookTour(@PathVariable("book_tour_id") String bookTourId) {
		BookTourDTO bookTourDTO = bookTourService.deleteBookTour(bookTourId);
		CommonResponse<String> response = new CommonResponse<>();
		if (bookTourDTO == null) {
			response.setMessage(Constants.FAIL);
			response.setData("Ban xoa khong thanh cong.");
			return ResponseEntity.ok(response);
		}
		response.setMessage(Constants.SUCCESS);
		response.setData("Ban xoa thanh cong");
		return ResponseEntity.ok(response);
	}
	
}
