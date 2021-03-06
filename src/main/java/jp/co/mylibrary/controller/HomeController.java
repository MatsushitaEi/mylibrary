package jp.co.mylibrary.controller;

import java.security.Principal;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.mylibrary.entity.UsersEntity;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String home(Locale locale, Principal principal) {
		// セッションからユーザーIDを取得
		Authentication authentication = (Authentication) principal;
		if (authentication == null)
			return "index";
		UsersEntity user = (UsersEntity) authentication.getPrincipal();

		if (user != null) {
			// TODO トップページのデザインを考える！
			return "mypage";
		}
		return "index";
	}
}
