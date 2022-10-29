package com.tuyendungvieclam.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tuyendungvieclam.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	
	
	public UserEntity findByUserName(String userName);

	public Page<UserEntity> findByActiveTrue(Pageable pageable);
}