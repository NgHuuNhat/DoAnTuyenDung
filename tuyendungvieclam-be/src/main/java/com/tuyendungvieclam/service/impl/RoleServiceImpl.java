package com.tuyendungvieclam.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuyendungvieclam.converter.RoleConverter;
import com.tuyendungvieclam.dto.RoleDTO;
import com.tuyendungvieclam.entity.RoleEntity;
import com.tuyendungvieclam.repository.RoleRepository;
import com.tuyendungvieclam.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleConverter roleConverter;
	
	@Override
	public List<RoleDTO> findAll() {
		List<RoleEntity> roleEntities = roleRepository.findAll();
		List<RoleDTO> result = new ArrayList<>();
		for(RoleEntity entity: roleEntities) {
			result.add(roleConverter.convertEntityToDto(entity));
		}
		return result;
	}

	@Override
	public Set<RoleDTO> findByRoleIdIn(List<String> listRoleId) {
		List<RoleEntity> roleEntities = roleRepository.findByRoleIdIn(listRoleId);
		Set<RoleDTO> result = new HashSet<>();
		for(RoleEntity entity: roleEntities) {
			result.add(roleConverter.convertEntityToDto(entity));
		}
		return result;
	}

	@Override
	public void saveRole(RoleDTO roleDTO) {
		RoleEntity roleEntity = roleConverter.convertDtoToEntity(roleDTO);
		roleRepository.save(roleEntity);
	}

}
