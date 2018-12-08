package jp.co.mylibrary.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import jp.co.mylibrary.dto.BooksAndReadBooksDto;
import jp.co.mylibrary.entity.ReadBooksEntity;

public class ReadBooksDaoImpl extends DaoSupport {

	@Transactional
	public void setReadBooks(ReadBooksEntity readBooksEntity) {
		getCurrentSession().save(readBooksEntity);
	}

	@Transactional
	public void updateReadBooks(ReadBooksEntity readBooksEntity) {
		getCurrentSession().update(readBooksEntity);
	}

	@SuppressWarnings("unchecked")
	public List<ReadBooksEntity> getReadBook(ReadBooksEntity readBooksEntity) {
		Criteria criteria = getCurrentSession().createCriteria(ReadBooksEntity.class)
				.add(Restrictions.eq("bookId", readBooksEntity.getBookId()))
				.add(Restrictions.eq("userId", readBooksEntity.getUserId()));
		List<ReadBooksEntity> readBooksList = criteria.list();
		return readBooksList;
	}

	@SuppressWarnings("unchecked")
	public List<BooksAndReadBooksDto> getReadBookByUserId(int userId) {
		List<BooksAndReadBooksDto> resultList = (List<BooksAndReadBooksDto>) getSession()
				.createSQLQuery(
						"SELECT b.book_id,b.book_name,b.author,b.total_page,b.img,r.user_id,r.read_page,r.end_flg FROM BOOKS b, READ_BOOKS r WHERE b.book_id = r.book_id AND user_id = :userId")
				.setInteger("userId", userId).list();
		return resultList;
	}
}
