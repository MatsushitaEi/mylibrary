package jp.co.mylibrary.controller;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.mylibrary.entity.UsersEntity;

/**
 * Servlet implementation class Mypage
 */

@Controller
public class MypageController extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "/mypage" }, method = RequestMethod.GET)
	public String doget(Locale locale, Model model, Principal principal) {

		// セッションからユーザーIDを取得
		Authentication authentication = (Authentication) principal;
		UsersEntity user = (UsersEntity) authentication.getPrincipal();
		int userId = user.getUserId();

		return "mypage";
	}
}
