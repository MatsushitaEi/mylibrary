package jp.co.mylibrary.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.mylibrary.entity.BooksEntity;

@Controller
public class updateBookController {
	@RequestMapping(value = { "/updateBook" }, method = RequestMethod.GET)
	public String doget(Locale locale, Model model, @ModelAttribute BooksEntity booksEntity) {

		// model.addAttribute("book", book.getBookName());
		return "addBook";
	}

	@RequestMapping(value = { "/updateBook" }, method = RequestMethod.POST)
	public String dopost(Locale locale, Model model, @ModelAttribute BooksEntity booksEntity) {

		// model.addAttribute("book", book.getBookName());
		return "addBook";
	}
}
