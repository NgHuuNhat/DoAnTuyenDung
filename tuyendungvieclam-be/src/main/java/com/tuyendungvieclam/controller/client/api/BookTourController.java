package com.tuyendungvieclam.controller.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tuyendungvieclam.common.Constants;
import com.tuyendungvieclam.dto.BookTourDTO;
import com.tuyendungvieclam.request.client.booktour.BookTourRequest;
import com.tuyendungvieclam.response.CommonResponse;
import com.tuyendungvieclam.service.BookTourService;

@RestController
public class BookTourController {
	
	@Autowired
	private BookTourService bookTourService;

	@PostMapping(value = "/api/book-tour")
	public ResponseEntity<CommonResponse<String>> bookTour(@RequestBody BookTourRequest request) {
		BookTourDTO bookTourDTO = bookTourService.bookTour(request);
		CommonResponse<String> response = new CommonResponse<>();
		if (bookTourDTO == null) {
			response.setMessage(Constants.FAIL);
			response.setData("Ung tuyen khong thanh cong");
			return ResponseEntity.ok(response);
		}
		response.setMessage(Constants.SUCCESS);
		response.setData("Ung tuyen thanh cong. Vui long kiem tra email");
		return ResponseEntity.ok(response);
	}
}
