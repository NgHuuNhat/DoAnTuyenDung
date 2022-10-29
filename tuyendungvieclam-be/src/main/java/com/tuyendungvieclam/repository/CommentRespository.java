package com.tuyendungvieclam.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tuyendungvieclam.entity.CommentEntity;
import com.tuyendungvieclam.entity.NewsEntity;

@Repository
public interface CommentRespository extends JpaRepository<CommentEntity, String>{

	List<CommentEntity> findAllByNewInfo(NewsEntity newsEntity);
	
}
