package com.tuyendungvieclam.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tuyendungvieclam.dto.CommentDTO;
import com.tuyendungvieclam.entity.CommentEntity;

@Component
public class CommentConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public CommentEntity converterDtoToEntity(CommentDTO dto) {
		CommentEntity result = modelMapper.map(dto, CommentEntity.class);
		return result;
	}
	
	public CommentDTO converterEntityToDto(CommentEntity entity) {
		if(entity == null) {
			return null;
		}
		CommentDTO result = modelMapper.map(entity, CommentDTO.class);
		return result;
	}
	
}
