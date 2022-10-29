package com.tuyendungvieclam.controller.admin.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tuyendungvieclam.common.Constants;
import com.tuyendungvieclam.dto.NewsDTO;
import com.tuyendungvieclam.request.admin.news.AddNewRequest;
import com.tuyendungvieclam.request.admin.news.UpdateNewsRequest;
import com.tuyendungvieclam.response.CommonResponse;
import com.tuyendungvieclam.response.admin.news.GetAllNewsResponse;
import com.tuyendungvieclam.service.NewsService;

@RestController
public class AdminNewsApi {
	
	@Autowired
	private NewsService newsService;

	@GetMapping(value = "/api/news")
	public ResponseEntity<List<GetAllNewsResponse>> getAllNews() {
		List<NewsDTO> newsDTOs = newsService.getAllNews();
		List<GetAllNewsResponse> result = new ArrayList<>();
		for (NewsDTO dto : newsDTOs) {
			result.add(GetAllNewsResponse.copy(dto));
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/api/news")
	public ResponseEntity<CommonResponse<String>> addNews(@RequestBody AddNewRequest request) {
		NewsDTO newsDTO = newsService.addNews(request);
		CommonResponse<String> response = new CommonResponse<>();
		if (newsDTO == null) {
			response.setMessage(Constants.FAIL);
			response.setData("Ban tao khong thanh cong");
			return ResponseEntity.ok(response);
		}
		response.setMessage(Constants.SUCCESS);
		response.setData("Ban tao thanh cong");
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "/api/news")
	public ResponseEntity<CommonResponse<String>> updateNews(@RequestBody UpdateNewsRequest request) {
		NewsDTO newsDTO = newsService.upDateNews(request);
		CommonResponse<String> response = new CommonResponse<>();
		if (newsDTO == null) {
			response.setMessage(Constants.FAIL);
			response.setData("update khong thanh cong");
			return ResponseEntity.ok(response);
		}
		response.setMessage(Constants.SUCCESS);
		response.setData("update thanh cong");
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value = "/api/news/{news_id}")
	public ResponseEntity<CommonResponse<String>> deleNews(@PathVariable("news_id") String newsId) {
		NewsDTO newsDTO = newsService.deleteNews(newsId);
		CommonResponse<String> response = new CommonResponse<>();
		if (newsDTO == null) {
			response.setMessage(Constants.FAIL);
			response.setData("xoa khong thanh cong.");
			return ResponseEntity.ok(response);
		}
		response.setMessage(Constants.SUCCESS);
		response.setData("xoa thanh cong");
		return ResponseEntity.ok(response);
	}
}
