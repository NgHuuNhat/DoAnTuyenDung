package com.tuyendungvieclam.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuyendungvieclam.converter.CommentConverter;
import com.tuyendungvieclam.dto.CommentDTO;
import com.tuyendungvieclam.dto.NewsDTO;
import com.tuyendungvieclam.dto.UserDTO;
import com.tuyendungvieclam.entity.CommentEntity;
import com.tuyendungvieclam.entity.NewsEntity;
import com.tuyendungvieclam.repository.CommentRespository;
import com.tuyendungvieclam.request.client.comment.CommentRequest;
import com.tuyendungvieclam.security.SecurityUtils;
import com.tuyendungvieclam.service.CommentService;
import com.tuyendungvieclam.service.NewsService;
import com.tuyendungvieclam.service.UserService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRespository commentRespository;
	
	@Autowired
	private CommentConverter commentConverter;
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private UserService userService;

	@Override
	public CommentDTO addComment(CommentRequest request) {
		NewsDTO newDTO = newsService.findByID(request.getNewId());
		if(newDTO == null) {
			return null;
		}
		String userName = SecurityUtils.getUserNameFromSecurity();
		if (userName == null) {
			return null;
		}
		UserDTO userDTO = userService.findByUserName(userName);
		CommentDTO result = new CommentDTO();
		result.setCommentId(UUID.randomUUID().toString());
		result.setContent(request.getContent());
		result.setNewInfo(newDTO);
		result.setUser(userDTO);
		result.setCreatedDate(LocalDateTime.now());
		result.setCreatedBy(userName);
		CommentEntity entity = commentConverter.converterDtoToEntity(result);
		commentRespository.save(entity);
		// TODO Auto-generated method stub
		return result;
	}
	
	@Override
	public List<CommentDTO> findAllByNewId(String newId) {
		NewsEntity newsEntity = newsService.findByNewId(newId);
		List<CommentEntity> commentEntities = commentRespository.findAllByNewInfo(newsEntity);
		List<CommentDTO> commentDTOs = new ArrayList<>();
		for (CommentEntity entity : commentEntities) {
			commentDTOs.add(commentConverter.converterEntityToDto(entity));
		}
		return commentDTOs;
	}

}
