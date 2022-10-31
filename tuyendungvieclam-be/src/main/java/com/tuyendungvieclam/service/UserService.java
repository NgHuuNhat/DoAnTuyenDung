package com.tuyendungvieclam.service;

import com.tuyendungvieclam.dto.UserDTO;
import com.tuyendungvieclam.request.admin.user.AddUserRequest;
import com.tuyendungvieclam.request.admin.user.UpdateUserRequest;
import com.tuyendungvieclam.response.admin.user.FindAllUserPagination;

public interface UserService {
	
	public UserDTO findByUserName(String userName);
	
	public FindAllUserPagination getAllUserAndPagination(int pageNumber, int pageSize);
	
	public UserDTO addUser(AddUserRequest request);
	
	public UserDTO updateUser(UpdateUserRequest request);

	public UserDTO deleteUser(String userName);

	public UserDTO addUserClient(AddUserRequest request);
}
