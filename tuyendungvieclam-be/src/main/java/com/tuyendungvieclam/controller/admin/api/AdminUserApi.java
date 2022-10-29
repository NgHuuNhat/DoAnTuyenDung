package com.tuyendungvieclam.controller.admin.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tuyendungvieclam.common.Constants;
import com.tuyendungvieclam.dto.UserDTO;
import com.tuyendungvieclam.request.admin.user.AddUserRequest;
import com.tuyendungvieclam.request.admin.user.UpdateUserRequest;
import com.tuyendungvieclam.response.CommonResponse;
import com.tuyendungvieclam.response.admin.user.FindAllUserPagination;
import com.tuyendungvieclam.service.UserService;

@RestController
public class AdminUserApi {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/api/user")
	public ResponseEntity<FindAllUserPagination> getAllUser(@RequestParam("page_number") int pageNumber, @RequestParam("page_size") int pageSize) {
		FindAllUserPagination result = userService.getAllUserAndPagination(pageNumber, pageSize);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/api/user")
	public ResponseEntity<CommonResponse<String>> addUser(@RequestBody AddUserRequest request) {
		UserDTO userDTO = userService.addUser(request);
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
	
	@PutMapping(value = "/api/user")
	public ResponseEntity<CommonResponse<String>> updateUser(@RequestBody UpdateUserRequest request) {
		UserDTO userDTO = userService.updateUser(request);
		CommonResponse<String> response = new CommonResponse<>();
		if (userDTO == null) {
			response.setMessage(Constants.FAIL);
			response.setData("username khong ton tai");
			return ResponseEntity.ok(response);
		}
		response.setMessage(Constants.SUCCESS);
		response.setData("update thanh cong");
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value = "/api/user/{user_name}")
	public ResponseEntity<CommonResponse<String>> updateUser(@PathVariable("user_name") String userName) {
		UserDTO userDTO = userService.deleteUser(userName);
		CommonResponse<String> response = new CommonResponse<>();
		if (userDTO == null) {
			response.setMessage(Constants.FAIL);
			response.setData("User name khong ton tai");
			return ResponseEntity.ok(response);
		}
		response.setMessage(Constants.SUCCESS);
		response.setData("xoa thanh cong");
		return ResponseEntity.ok(response);
	}
}
