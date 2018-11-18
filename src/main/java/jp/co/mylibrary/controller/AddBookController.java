package jp.co.mylibrary.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.mylibrary.entity.BooksEntity;;

@Controller
public class AddBookController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "/addBook" }, method = RequestMethod.GET)
	public String doget(Locale locale, Model model, @ModelAttribute BooksEntity booksEntity) {

		// model.addAttribute("book", book.getBookName());
		return "addBook";
	}
}
