package com.tuyendungvieclam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tuyendungvieclam.entity.BookTourEntity;

@Repository
public interface BookTourRepository extends JpaRepository<BookTourEntity, String>{

	BookTourEntity findByBookTourId(String bookTourId);
	
}
