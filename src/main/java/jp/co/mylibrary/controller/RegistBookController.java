package jp.co.mylibrary.controller;

import java.security.Principal;
import java.util.Date;
import java.util.Locale;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.mylibrary.dto.BooksAndReadBooksDto;
import jp.co.mylibrary.entity.BooksEntity;
import jp.co.mylibrary.entity.ReadBooksEntity;
import jp.co.mylibrary.entity.ReadPageEntity;
import jp.co.mylibrary.entity.UsersEntity;
import jp.co.mylibrary.service.BooksService;
import jp.co.mylibrary.service.ReadBooksService;
import jp.co.mylibrary.service.ReadPageService;

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

	@RequestMapping(value = { "/editBook" }, method = RequestMethod.POST)
	public String doget(Locale locale, Model model, @ModelAttribute BooksAndReadBooksDto booksAndReadBooksDto,
			Principal principal) {

		int bookId = booksAndReadBooksDto.getBookId();
		int readPage = booksAndReadBooksDto.getReadPage();
		int nowReadpage = booksAndReadBooksDto.getNowReadPage();
		int totalPage = booksAndReadBooksDto.getTotalPage();

		// 読んだページ数に以前と変化が無い場合はそのまま返す
		if (readPage == nowReadpage)
			return "redirect:history";

		// セッションからユーザーIDを取得
		Authentication authentication = (Authentication) principal;
		UsersEntity user = (UsersEntity) authentication.getPrincipal();
		int userId = user.getUserId();

		// ユーザーと書籍の情報をひもづける
		ReadBooksService readBooksService = new ReadBooksService();
		ReadBooksEntity readBooksEntity = new ReadBooksEntity();
		readBooksEntity.setBookId(bookId);
		readBooksEntity.setReadPage(nowReadpage);
		readBooksEntity.setUserId(userId);

		if (totalPage <= nowReadpage) {
			Date date = new Date();
			final int END_FLG = 1;
			readBooksEntity.setReadPage(totalPage);
			readBooksEntity.setEndDate(date);
			readBooksEntity.setEndFlg(END_FLG);
		}

		readBooksService.updateReadBooks(readBooksEntity);

		// 読んだページ数を格納
		int updatePage = nowReadpage - readPage;

		ReadPageService readPageService = new ReadPageService();
		ReadPageEntity readPageEntity = new ReadPageEntity();
		readPageEntity.setBookId(booksAndReadBooksDto.getBookId());
		readPageEntity.setUserId(userId);
		readPageEntity.setReadPage(updatePage);
		readPageService.setReadPage(readPageEntity);

		// model.addAttribute("book", book.getBookName());
		return "redirect:history";
	}
}
