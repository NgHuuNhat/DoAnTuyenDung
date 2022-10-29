package com.tuyendungvieclam.service;

import java.util.List;
import java.util.Set;
import com.tuyendungvieclam.dto.RoleDTO;

public interface RoleService {
	
	public List<RoleDTO> findAll();
	
	public Set<RoleDTO> findByRoleIdIn(List<String> listRoleId);
	
	public void saveRole(RoleDTO roleDTO);

}
