package com.tuyendungvieclam.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tuyendungvieclam.dto.UserDTO;
import com.tuyendungvieclam.entity.UserEntity;

@Component
public class UserConverter {

	@Autowired
	private ModelMapper modelMapper;

	public UserEntity convertDtoToEntity(UserDTO dto) {
		UserEntity result = modelMapper.map(dto, UserEntity.class);
		return result;
	}

	public UserDTO convertEntityToDto(UserEntity entity) {
		if (entity == null) {
			return null;
		}
		UserDTO result = modelMapper.map(entity, UserDTO.class);
		return result;
	}

}
