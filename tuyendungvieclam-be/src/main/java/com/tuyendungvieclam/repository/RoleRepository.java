package com.tuyendungvieclam.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tuyendungvieclam.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String> {
	
	
	public List<RoleEntity> findByRoleIdIn(List<String> listRoleId);
	
	public RoleEntity findByRoleId(String roleId);
}
