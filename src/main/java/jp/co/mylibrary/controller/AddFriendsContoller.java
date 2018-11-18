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

import jp.co.mylibrary.entity.UsersEntity;

@Controller
public class AddFriendsContoller {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = {"/addFriends"}, method = RequestMethod.GET)
	public String doget(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		//logger.debug("test", person);
		//PersonModel name = new PersonModel();
		//model.addAttribute("name", name.getName() );
		
		return "addFriends";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@RequestMapping(value = {"/addfriends"}, method = RequestMethod.POST)
	public String dopost(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
				
		//logger.debug("test", person);
		
		//model.addAttribute("name", person.getName() );
		
		return "addFriends";
	}
}
