package jp.co.mylibrary.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.mylibrary.dao.ReadBooksDaoImpl;
import jp.co.mylibrary.dto.BooksAndReadBooksDto;
import jp.co.mylibrary.entity.UsersEntity;

@Controller
public class HistoryContoller {

	@RequestMapping(value = { "/history" }, method = RequestMethod.GET)
	public String doget(Locale locale, Model model, Principal principal) {

		Authentication authentication = (Authentication) principal;
		UsersEntity user = (UsersEntity) authentication.getPrincipal();

		ReadBooksDaoImpl readBooksDaoImpl = new ReadBooksDaoImpl();
		readBooksDaoImpl.openCurrentSession();
		// TODO ゴリ押しすぎるからテーブル構造等の見直しが必要
		List<BooksAndReadBooksDto> bookList = readBooksDaoImpl.getReadBookByUserId(user.getUserId());

		model.addAttribute("list", bookList);

		return "history";
	}
}
