package com.tuyendungvieclam.controller.admin.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tuyendungvieclam.dto.RoleDTO;
import com.tuyendungvieclam.response.admin.role.GetAllRoleResponse;
import com.tuyendungvieclam.service.RoleService;

@RestController
public class AdminRoleApi {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value = "/api/role")
	public ResponseEntity<List<GetAllRoleResponse>> findAll() {
		List<RoleDTO> roleDTOs = roleService.findAll();
		List<GetAllRoleResponse> result = new ArrayList<>();
		for(RoleDTO roleDTO : roleDTOs) {
			result.add(GetAllRoleResponse.copy(roleDTO));
		}
		return ResponseEntity.ok(result);
	}

}
