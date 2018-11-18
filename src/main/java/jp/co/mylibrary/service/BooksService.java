package jp.co.mylibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.mylibrary.dao.BooksDaoImpl;
import jp.co.mylibrary.entity.BooksEntity;

@Service
public class BooksService {

	/**
	 * 書籍を登録するメソッド
	 * 
	 * @param booksEntity
	 */

	@Transactional
	public boolean setBooks(BooksEntity booksEntity) {
		BooksDaoImpl booksDaoImpl = new BooksDaoImpl();
		booksDaoImpl.openCurrentSessionwithTransaction();
		if (booksDaoImpl.getBook(booksEntity) == null) {
			booksEntity.prePersist();
			booksDaoImpl.setBooks(booksEntity);
			booksDaoImpl.closeCurrentSessionwithTransaction();
			return true;
		} else {
			booksDaoImpl.closeCurrentSessionwithTransaction();
			return false;
		}
	}

	public BooksEntity getBook(BooksEntity booksEntity) {
		BooksDaoImpl booksDaoImpl = new BooksDaoImpl();
		booksDaoImpl.openCurrentSession();
		BooksEntity book = booksDaoImpl.getBook(booksEntity);
		booksDaoImpl.closeCurrentSession();
		return book;
	}

}
