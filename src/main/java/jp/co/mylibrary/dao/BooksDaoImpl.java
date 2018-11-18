package jp.co.mylibrary.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import jp.co.mylibrary.entity.BooksEntity;

public class BooksDaoImpl extends DaoSupport {

	@Transactional
	public void setBooks(BooksEntity booksEntity) {
		getCurrentSession().save(booksEntity);
	}

	public BooksEntity getBook(BooksEntity booksEntity) {
		Criteria criteria = getCurrentSession().createCriteria(BooksEntity.class)
				.add(Restrictions.eq("bookName", booksEntity.getBookName()))
				.add(Restrictions.eq("author", booksEntity.getAuthor()))
				.add(Restrictions.eq("totalPage", booksEntity.getTotalPage()));
		BooksEntity book = (BooksEntity) criteria.uniqueResult();
		return book;
	}

	public List<BooksEntity> getBook() {
		@SuppressWarnings("unchecked")
		List<BooksEntity> bookList = getCurrentSession().createCriteria(BooksEntity.class).list();
		return bookList;
	}

}
