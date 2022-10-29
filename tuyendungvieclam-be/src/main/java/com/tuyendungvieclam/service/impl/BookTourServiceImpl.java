package com.tuyendungvieclam.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuyendungvieclam.converter.BookTourConverter;
import com.tuyendungvieclam.dto.BookTourDTO;
import com.tuyendungvieclam.entity.BookTourEntity;
import com.tuyendungvieclam.repository.BookTourRepository;
import com.tuyendungvieclam.request.admin.booktour.UpdateBookTourRequest;
import com.tuyendungvieclam.request.client.booktour.BookTourRequest;

import com.tuyendungvieclam.service.BookTourService;

@Service
@Transactional
public class BookTourServiceImpl implements BookTourService {

	@Autowired
	private BookTourRepository bookTourRepository;

	@Autowired
	private BookTourConverter bookTourConverter;

	@Autowired
	private EMailImpl eMailImpl;

	@Override
	public BookTourDTO bookTour(BookTourRequest request) {
		BookTourDTO tourDTO = new BookTourDTO();
		try {
			tourDTO.setBookTourId(UUID.randomUUID().toString());
			tourDTO.setUserName(request.getUserName());
			tourDTO.setNewId(request.getNewId());
			tourDTO.setEmailCustomer(request.getEmailCustomer());
			tourDTO.setPhoneNumberCustomer(request.getPhoneNumberCustomer());
			tourDTO.setCreatedDate(LocalDateTime.now());
			tourDTO.setCreatedBy(request.getUserName());
			tourDTO.setFullNameCustomer(request.getFullNameCustomer());
			BookTourEntity bookTourEntity = bookTourConverter.converterDtoToEntity(tourDTO);
			bookTourRepository.save(bookTourEntity);

			eMailImpl.sendEmail(request.getEmailCustomer(), "Tuyen Dung Viec Lam thong bao","Cam on ban da ung tuyen :3!");
			} catch (Exception e) {
					System.out.println("ERROR " + e.toString());
				} finally {
					System.out.println("123123213");
					}
		return tourDTO;
	}

	@Override
	public BookTourDTO findByID(String id) {
		try {
			BookTourEntity bookTourEntity = bookTourRepository.findByBookTourId(id);
			BookTourDTO bookTourDTO = bookTourConverter.converterEntityToDto(bookTourEntity);
			return bookTourDTO;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<BookTourDTO> getAllBookTour() {
		// select * from News; = newsRepository.findAll();
		List<BookTourEntity> a = bookTourRepository.findAll();
		List<BookTourDTO> b = new ArrayList<>();
		for (BookTourEntity entity : a) {
			b.add(bookTourConverter.converterEntityToDto(entity));
		}
		return b;
	}

	@Override
	public BookTourDTO upDateBookTour(UpdateBookTourRequest request) {
		BookTourEntity bookTourEntity = bookTourRepository.findByBookTourId(request.getBookTourId());
		BookTourDTO bookTourDTO = bookTourConverter.converterEntityToDto(bookTourEntity);
		if (bookTourDTO == null) {
			return null;
		}
		bookTourDTO.setAddressCustomer(request.getAddressCustomer());
		bookTourDTO.setEmailCustomer(request.getEmailCustomer());
		bookTourDTO.setBookTourId(request.getBookTourId());
		bookTourDTO.setFullNameCustomer(request.getFullNameCustomer());
		bookTourDTO.setPhoneNumberCustomer(request.getPhoneNumberCustomer());
		bookTourDTO.setUserName(request.getUserName());
		bookTourRepository.save(bookTourConverter.converterDtoToEntity(bookTourDTO));
		return bookTourDTO;
	}

	@Override
	public BookTourDTO deleteBookTour(String bookTourId) {
		BookTourEntity bookTourEntity = bookTourRepository.findByBookTourId(bookTourId);
		BookTourDTO bookTourDTO = bookTourConverter.converterEntityToDto(bookTourEntity);
		if (bookTourDTO == null) {
			return null;
		}
		bookTourRepository.delete(bookTourId);
		return bookTourDTO;
	}

}
