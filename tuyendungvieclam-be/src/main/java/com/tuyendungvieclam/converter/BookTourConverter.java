package com.tuyendungvieclam.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tuyendungvieclam.dto.BookTourDTO;
import com.tuyendungvieclam.entity.BookTourEntity;

@Component
public class BookTourConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public BookTourEntity converterDtoToEntity(BookTourDTO dto) {
		BookTourEntity result = modelMapper.map(dto, BookTourEntity.class);
		return result;
	}
	
	public BookTourDTO converterEntityToDto(BookTourEntity entity) {
		BookTourDTO result = modelMapper.map(entity, BookTourDTO.class);
		return result;
	}
}