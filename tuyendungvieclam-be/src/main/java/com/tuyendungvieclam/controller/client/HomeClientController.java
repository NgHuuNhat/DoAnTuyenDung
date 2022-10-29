package com.tuyendungvieclam.controller.client;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.tuyendungvieclam.dto.NewsDTO;
import com.tuyendungvieclam.response.admin.news.GetAllNewsResponse;
import com.tuyendungvieclam.response.client.news.NewsInfoResponse;
import com.tuyendungvieclam.service.NewsService;

@Controller
public class HomeClientController {
	
	@Autowired
	private NewsService newsService;

	@GetMapping(value = "/")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("client/home");
		List<NewsDTO> newsDTOs = newsService.getAllNews();
		List<GetAllNewsResponse> result = new ArrayList<>();
		for (NewsDTO dto : newsDTOs) {
			result.add(GetAllNewsResponse.copy(dto));
		}
		mav.addObject("news", result);
		return mav;
	}
	
	@GetMapping(value = "/client/news/{new_id}")
	public ModelAndView detailPage(@PathVariable("new_id") String newId) {
		ModelAndView mav = new ModelAndView("client/news/detail");
		NewsDTO newsDTO = newsService.findByID(newId);
		NewsInfoResponse result = NewsInfoResponse.copy(newsDTO);
		mav.addObject("news", result);
		return mav;
	}
}
