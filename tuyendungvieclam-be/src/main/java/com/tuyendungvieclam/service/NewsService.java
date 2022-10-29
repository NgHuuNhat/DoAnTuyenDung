package com.tuyendungvieclam.service;

import java.util.List;
import com.tuyendungvieclam.dto.NewsDTO;
import com.tuyendungvieclam.entity.NewsEntity;
import com.tuyendungvieclam.request.admin.news.AddNewRequest;
import com.tuyendungvieclam.request.admin.news.UpdateNewsRequest;

public interface NewsService {

	public NewsDTO findByID(String id);
	
	public List<NewsDTO> getAllNews();

	public NewsDTO addNews(AddNewRequest request);

	public NewsDTO upDateNews(UpdateNewsRequest request);

	public NewsDTO deleteNews(String id);
	
	public NewsEntity findByNewId(String newId);
	
}
