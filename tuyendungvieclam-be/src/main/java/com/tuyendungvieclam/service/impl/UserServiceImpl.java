package com.tuyendungvieclam.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.tuyendungvieclam.converter.UserConverter;
import com.tuyendungvieclam.dto.RoleDTO;
import com.tuyendungvieclam.dto.UserDTO;
import com.tuyendungvieclam.entity.UserEntity;
import com.tuyendungvieclam.repository.UserRepository;
import com.tuyendungvieclam.request.admin.user.AddUserRequest;
import com.tuyendungvieclam.request.admin.user.UpdateUserRequest;
import com.tuyendungvieclam.response.CommonPagination;
import com.tuyendungvieclam.response.admin.user.FindAllUserPagination;
import com.tuyendungvieclam.response.admin.user.UserInfoResponse;
import com.tuyendungvieclam.security.SecurityUtils;
import com.tuyendungvieclam.service.RoleService;
import com.tuyendungvieclam.service.UserService;
import com.tuyendungvieclam.utils.FileUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RoleService roleService;

	@Override
	public UserDTO findByUserName(String userName) {
		try {
			UserEntity userEntity = userRepository.findByUserName(userName);
			UserDTO userDTO = userConverter.convertEntityToDto(userEntity);
			return userDTO;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public FindAllUserPagination getAllUserAndPagination(int pageNumber, int pageSize) {
		FindAllUserPagination result = new FindAllUserPagination();
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize);
		
		//query phân trang
		Page<UserEntity> pageUsers = userRepository.findByActiveTrue(pageable);
		List<UserDTO> userDTOs = new ArrayList<>();
		for(UserEntity entity: pageUsers.getContent()) {
			userDTOs.add(userConverter.convertEntityToDto(entity));
		}
		
		//add danh sách phân trang gồm pageSize được truy�?n vào là bao nhiêu
		List<UserInfoResponse> userInfoList = new ArrayList<>();
		for(UserDTO userDTO: userDTOs) {
			userInfoList.add(UserInfoResponse.copy(userDTO));
		} 
		result.setUserInfoList(userInfoList);
		
		//add total_item, total_page, page_number, page_size
		CommonPagination pagination = new CommonPagination(pageNumber, pageSize, pageUsers.getTotalPages(), pageUsers.getTotalElements());
		result.setPagination(pagination);
		return result;
	}

	@Override
	public UserDTO addUser(AddUserRequest request) {
		UserEntity userEntity = userRepository.findByUserName(request.getUserName());
		UserDTO userDTO = userConverter.convertEntityToDto(userEntity);
		if (userDTO != null) {
			return null;
		}
		String avatar = FileUtils.uploadFile(request.getBase64(), request.getFileName(), "users");
		userDTO = new UserDTO();
		userDTO.setUserName(request.getUserName());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userDTO.setPassword(passwordEncoder.encode(request.getPassword()));
		userDTO.setFullName(request.getFullName());
		userDTO.setEmail(request.getEmail());
		userDTO.setPhoneNumber(request.getPhoneNumber());
		userDTO.setActive(true);
		userDTO.setCreatedDate(LocalDateTime.now());
		userDTO.setCreatedBy(SecurityUtils.getUserNameFromSecurity());
		userDTO.setAvatar(avatar);
		userRepository.save(userConverter.convertDtoToEntity(userDTO));
		
		Set<RoleDTO> roleDTOs = roleService.findByRoleIdIn(request.getListRole());
		for(RoleDTO roleDTO: roleDTOs) {
			roleDTO.getUserSet().add(userDTO);
			roleService.saveRole(roleDTO);
		}
		return userDTO;
	}

	@Override
	public UserDTO updateUser(UpdateUserRequest request) {
		UserEntity userEntity = userRepository.findByUserName(request.getUserName());
		UserDTO userDTO = userConverter.convertEntityToDto(userEntity);
		if (userDTO == null) {
			return null;
		}
		userDTO.setFullName(request.getFullName());
		userDTO.setEmail(request.getEmail());
		userDTO.setPhoneNumber(request.getPhoneNumber());
		userDTO.setPassword(request.getPassword());
		userDTO.setUpdatedDate(LocalDateTime.now());
		userDTO.setUpdatedBy(SecurityUtils.getUserNameFromSecurity());
		userRepository.save(userConverter.convertDtoToEntity(userDTO));
		return userDTO;
	}

	@Override
	public UserDTO deleteUser(String userName) {
		UserEntity userEntity = userRepository.findByUserName(userName);
		UserDTO userDTO = userConverter.convertEntityToDto(userEntity);
		if (userDTO == null) {
			return null;
		}
		userDTO.setActive(false);
		userRepository.save(userConverter.convertDtoToEntity(userDTO));
		return userDTO;
	}
}