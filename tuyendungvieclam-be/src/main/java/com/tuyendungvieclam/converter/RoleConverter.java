package com.tuyendungvieclam.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tuyendungvieclam.dto.RoleDTO;
import com.tuyendungvieclam.entity.RoleEntity;

@Component
public class RoleConverter {

	@Autowired
	private ModelMapper modelMapper;

	public RoleEntity convertDtoToEntity(RoleDTO dto) {
		RoleEntity result = modelMapper.map(dto, RoleEntity.class);
		return result;
	}

	public RoleDTO convertEntityToDto(RoleEntity entity) {
		if (entity == null) {
			return null;
		}
		RoleDTO result = modelMapper.map(entity, RoleDTO.class);
		return result;
	}
}
