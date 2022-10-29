package com.tuyendungvieclam.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuyendungvieclam.converter.NewsConverter;
import com.tuyendungvieclam.dto.NewsDTO;
import com.tuyendungvieclam.dto.UserDTO;
import com.tuyendungvieclam.entity.NewsEntity;
import com.tuyendungvieclam.repository.NewsRepository;
import com.tuyendungvieclam.request.admin.news.AddNewRequest;
import com.tuyendungvieclam.request.admin.news.UpdateNewsRequest;
import com.tuyendungvieclam.security.SecurityUtils;
import com.tuyendungvieclam.service.NewsService;
import com.tuyendungvieclam.service.UserService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private NewsConverter newsConverter;
	
	@Autowired
	private UserService userService;
	

	@Override
	public NewsDTO findByID(String id) {
		try {
			NewsEntity newsEntity = newsRepository.findByNewId(id);
			NewsDTO newsDTO = newsConverter.converterEntityToDto(newsEntity);
			return newsDTO;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<NewsDTO> getAllNews() {
		//select * from News; = newsRepository.findAll();
		List<NewsEntity> a = newsRepository.findAll();
		List<NewsDTO> b = new ArrayList<>();
		for (NewsEntity entity : a) {
			b.add(newsConverter.converterEntityToDto(entity));
		}
		return b;
	}

	@Override
	public NewsDTO addNews(AddNewRequest request) {
		try {
			NewsDTO newsDTO = new NewsDTO();
			newsDTO.setCreatedBy(SecurityUtils.getUserNameFromSecurity());
			newsDTO.setCreatedDate(LocalDateTime.now());
			newsDTO.setNewId(UUID.randomUUID().toString());
			newsDTO.setShortDescription(request.getShortDescription());
			newsDTO.setContent(request.getContent());
			newsDTO.setImages(request.getImages());
			newsDTO.setCapBac(request.getCapBac());
			newsDTO.setHanNopHoSo(request.getHanNopHoSo());
			newsDTO.setHinhThucLamViec(request.getHinhThucLamViec());
			newsDTO.setKinhNghiem(request.getKinhNghiem());
			newsDTO.setMucLuong(request.getMucLuong());
			newsDTO.setSoLuongTuyen(request.getSoLuongTuyen());
			newsDTO.setTenCongTy(request.getTenCongTy());
			
			UserDTO userDTO = userService.findByUserName(SecurityUtils.getUserNameFromSecurity());
			newsDTO.setUser(userDTO);
			newsRepository.save(newsConverter.converterDtoToEntity(newsDTO));
			return newsDTO;
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public NewsDTO upDateNews(UpdateNewsRequest request) {
		NewsEntity newsEntity = newsRepository.findByNewId(request.getNewId());
		NewsDTO newsDTO = newsConverter.converterEntityToDto(newsEntity);
		if (newsDTO == null) {
			return null;
		}
		newsDTO.setCreatedBy(SecurityUtils.getUserNameFromSecurity());
		newsDTO.setCreatedDate(LocalDateTime.now());
		newsDTO.setShortDescription(request.getShortDescription());
		newsDTO.setContent(request.getContent());
		newsDTO.setImages(request.getImages());
		newsDTO.setCapBac(request.getCapBac());
		newsDTO.setHanNopHoSo(request.getHanNopHoSo());
		newsDTO.setHinhThucLamViec(request.getHinhThucLamViec());
		newsDTO.setKinhNghiem(request.getKinhNghiem());
		newsDTO.setMucLuong(request.getMucLuong());
		newsDTO.setSoLuongTuyen(request.getSoLuongTuyen());
		newsDTO.setTenCongTy(request.getTenCongTy());
		UserDTO userDTO = userService.findByUserName(SecurityUtils.getUserNameFromSecurity());
		newsDTO.setUser(userDTO);
		newsRepository.save(newsConverter.converterDtoToEntity(newsDTO));
		return newsDTO;
	}

	@Override
	public NewsDTO deleteNews(String id) {
		NewsEntity newsEntity = newsRepository.findByNewId(id);
		NewsDTO newsDTO = newsConverter.converterEntityToDto(newsEntity);
		if (newsDTO == null) {
			return null;
		}
		newsRepository.delete(id);
		return newsDTO;
	}

	@Override
	public NewsEntity findByNewId(String newId) {
		NewsEntity newsEntity = newsRepository.findByNewId(newId);
		return newsEntity;
	}
}
