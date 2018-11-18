package jp.co.mylibrary.controller;

import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.mylibrary.entity.*;

@Controller
public class ShowFriendsController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = {"/showFriends"}, method = RequestMethod.GET)
	public String doget(Locale locale, Model model, @ModelAttribute UsersEntity person) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		UsersEntity name = new UsersEntity();
		model.addAttribute("name", name.getName() );
		
		return "showFriends";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@RequestMapping(value = {"/showFriends"}, method = RequestMethod.POST)
	public String dopost(Locale locale, Model model, @ModelAttribute UsersEntity person) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		
		model.addAttribute("name", person.getName() );
		
		return "showFriends";
	}
}
