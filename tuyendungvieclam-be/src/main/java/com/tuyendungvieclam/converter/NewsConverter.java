package com.tuyendungvieclam.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tuyendungvieclam.dto.NewsDTO;
import com.tuyendungvieclam.entity.NewsEntity;

@Component
public class NewsConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public NewsEntity converterDtoToEntity(NewsDTO dto) {
		NewsEntity result = modelMapper.map(dto, NewsEntity.class);
		return result;
	}
	
	public NewsDTO converterEntityToDto(NewsEntity entity) {
		if(entity == null) {
			return null;
		}
		NewsDTO result = modelMapper.map(entity, NewsDTO.class);
		return result;
	}
	
}