package com.tuyendungvieclam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tuyendungvieclam.entity.NewsEntity;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, String>{
	
	NewsEntity findByNewId(String newId);

}
