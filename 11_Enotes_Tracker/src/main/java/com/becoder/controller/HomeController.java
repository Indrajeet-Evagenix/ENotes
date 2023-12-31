package com.becoder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.becoder.dao.UserDao;
import com.becoder.entity.User;

@Controller
public class HomeController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	/*
	 * @RequestMapping("/addNotes") public String addNotes() { return "add_notes"; }
	 * 
	 * @RequestMapping("/viewNotes") public String viewNotes() { return
	 * "view_notes"; }
	 * 
	 * @RequestMapping("/editNotes") public String editNotes() { return
	 * "edit_notes"; }
	 */

	@RequestMapping(path = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user, HttpSession session, @RequestParam("email") String email) {

//		System.out.println(user);

//		user = userDao.loginCheck(email);

//		if (user.getEmail() != email) {
			userDao.saveUser(user);
			session.setAttribute("msg", "User Registered Successfully");
//		} else {
//			session.setAttribute("msg", "User Already Registered");
//
//		}

		return "redirect:/register";
	}

	@RequestMapping(path = "/loginUser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		User user = userDao.login(email, password);

		if (user != null) {
			session.setAttribute("userObj", user);
			return "redirect:/home";
		} else {
			session.setAttribute("msg", "Invalid Credentials");
			return "redirect:/login";
		}

	}

}
