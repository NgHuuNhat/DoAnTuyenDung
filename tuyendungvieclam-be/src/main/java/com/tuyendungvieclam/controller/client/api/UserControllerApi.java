package com.tuyendungvieclam.controller.client.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tuyendungvieclam.common.Constants;
import com.tuyendungvieclam.dto.UserDTO;
import com.tuyendungvieclam.request.admin.user.AddUserRequest;
import com.tuyendungvieclam.response.CommonResponse;
import com.tuyendungvieclam.service.UserService;

@RestController
public class UserControllerApi {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/api/client/user")
	public ResponseEntity<CommonResponse<String>> addUser(@RequestBody AddUserRequest request) {
		List<String> listRole = new ArrayList<String>();
		listRole.add("USER");
		request.setListRole(listRole);
		UserDTO userDTO = userService.addUserClient(request);
		CommonResponse<String> response = new CommonResponse<>();
		if (userDTO == null) {
			response.setMessage(Constants.FAIL);
			response.setData("username da ton tai");
			return ResponseEntity.ok(response);
		}
		response.setMessage(Constants.SUCCESS);
		response.setData("tao username thanh cong");
		return ResponseEntity.ok(response);
	}

}
