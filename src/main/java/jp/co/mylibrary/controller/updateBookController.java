package jp.co.mylibrary.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.mylibrary.dto.BooksAndReadBooksDto;;

@Controller
public class UpdateBookController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "/updateBook" }, method = RequestMethod.POST)
	public String doget(Locale locale, Model model, @ModelAttribute BooksAndReadBooksDto booksAndReadBooksDto) {

		// model.addAttribute("book", book.getBookName());
		return "updateBook";
	}
}
