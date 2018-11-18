package jp.co.mylibrary.controller;

import java.security.Principal;
import java.util.Locale;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.mylibrary.entity.BooksEntity;
import jp.co.mylibrary.entity.ReadBooksEntity;
import jp.co.mylibrary.entity.UsersEntity;
import jp.co.mylibrary.service.BooksService;
import jp.co.mylibrary.service.ReadBooksService;

@Controller
public class RegistBookController {

	@RequestMapping(value = { "/registBook" }, method = RequestMethod.POST)
	public String doget(Locale locale, Model model, @ModelAttribute BooksEntity booksEntity, Principal principal) {

		// 本の追加
		BooksService booksService = new BooksService();
		booksService.setBooks(booksEntity);
		BooksEntity book = booksService.getBook(booksEntity);

		// セッションからユーザーIDを取得
		Authentication authentication = (Authentication) principal;
		UsersEntity user = (UsersEntity) authentication.getPrincipal();
		int userId = user.getUserId();

		// ユーザーと書籍の情報をひもづける
		ReadBooksService readBooksService = new ReadBooksService();
		ReadBooksEntity readBooksEntity = new ReadBooksEntity();
		readBooksEntity.setBookId(book.getBookId());
		readBooksEntity.setUserId(userId);
		readBooksService.setReadBooks(readBooksEntity);

		// model.addAttribute("book", book.getBookName());
		return "redirect:history";
	}
}
