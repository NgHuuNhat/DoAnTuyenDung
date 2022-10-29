package com.tuyendungvieclam.controller.admin;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.tuyendungvieclam.dto.BookTourDTO;
import com.tuyendungvieclam.dto.NewsDTO;
import com.tuyendungvieclam.dto.RoleDTO;
import com.tuyendungvieclam.dto.UserDTO;
import com.tuyendungvieclam.response.admin.booktour.ViewUpdateBookTourResponse;
import com.tuyendungvieclam.response.admin.news.ViewUpdateNewsResponse;
import com.tuyendungvieclam.response.admin.user.ViewUpdateUserResponse;
import com.tuyendungvieclam.service.BookTourService;
import com.tuyendungvieclam.service.NewsService;
import com.tuyendungvieclam.service.RoleService;
import com.tuyendungvieclam.service.UserService;

@Controller
public class HomeAdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private BookTourService bookTourService;

	//admin
	@GetMapping(value = "/admin")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
	
	//user
	@GetMapping(value = "/admin/user")
	public ModelAndView userPage() {
		ModelAndView mav = new ModelAndView("admin/user/home");
		return mav;
	}
	
	@GetMapping(value = "/admin/user/add-user")
	public ModelAndView addUserPage() {
		ModelAndView mav = new ModelAndView("admin/user/add");
		return mav;
	}
	
	@GetMapping(value = "/admin/user/update-user/{user_name}")
	public ModelAndView updateUserPage(@PathVariable("user_name") String userName) {
		ModelAndView mav = new ModelAndView("admin/user/update");
		UserDTO userDTO = userService.findByUserName(userName);
		if (userDTO == null) {
			return mav;
		}
		Set<RoleDTO> roleDTOs = new HashSet<>(roleService.findAll());
		ViewUpdateUserResponse response = ViewUpdateUserResponse.copy(userDTO, roleDTOs);
		mav.addObject("userDTO", response);
		return mav;
	}
	
	//news
	@GetMapping(value = "/admin/news")
	public ModelAndView newsPage() {
		ModelAndView mav = new ModelAndView("admin/news/home");
		return mav;
	}
	
	@GetMapping(value = "/admin/news/add-news")
	public ModelAndView addNewsPage() {
		ModelAndView mav = new ModelAndView("admin/news/add");
		return mav;
	}
	
	@GetMapping(value = "/admin/news/update-news/{new_id}")
	public ModelAndView updateNews(@PathVariable("new_id") String id) {
		ModelAndView mav = new ModelAndView("admin/news/update");
		NewsDTO newsDTO = newsService.findByID(id);
		if (newsDTO == null) {
			return mav;
		}
		ViewUpdateNewsResponse response = ViewUpdateNewsResponse.copy(newsDTO);
		mav.addObject("newsDTO", response);
		return mav;
	}
	
	// comment
	@GetMapping(value = "/admin/comment")
	public ModelAndView commentPage() {
		ModelAndView mav = new ModelAndView("admin/comment/home");
		return mav;
	}

	// booktour
	@GetMapping(value = "/admin/booktour")
	public ModelAndView booktourPage() {
		ModelAndView mav = new ModelAndView("admin/booktour/home");
		return mav;
	}
	
	@GetMapping(value = "/admin/booktour/update-booktour/{book_tour_id}")
	public ModelAndView updateBookTour(@PathVariable("book_tour_id") String id) {
		ModelAndView mav = new ModelAndView("admin/booktour/update");
		BookTourDTO bookTourDTO = bookTourService.findByID(id);
		if (bookTourDTO == null) {
			return mav;
		}
		ViewUpdateBookTourResponse response = ViewUpdateBookTourResponse.copy(bookTourDTO);
		mav.addObject("bookTourDTO", response);
		return mav;
	}
}
