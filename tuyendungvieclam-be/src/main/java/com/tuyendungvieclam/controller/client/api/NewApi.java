package com.tuyendungvieclam.controller.client.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tuyendungvieclam.dto.NewsDTO;
import com.tuyendungvieclam.response.admin.news.GetAllNewsResponse;
import com.tuyendungvieclam.service.NewsService;

@RestController
public class NewApi {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping(value = "/client/news")
	public ResponseEntity<List<GetAllNewsResponse>> getAllNews() {
		List<NewsDTO> newsDTOs = newsService.getAllNews();
		List<GetAllNewsResponse> result = new ArrayList<>();
		for (NewsDTO dto : newsDTOs) {
			result.add(GetAllNewsResponse.copy(dto));
		}
		return ResponseEntity.ok(result);
	}

}
