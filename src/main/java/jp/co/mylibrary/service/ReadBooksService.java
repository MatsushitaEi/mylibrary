package jp.co.mylibrary.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jp.co.mylibrary.dao.ReadBooksDaoImpl;
import jp.co.mylibrary.dto.BooksAndReadBooksDto;
import jp.co.mylibrary.entity.ReadBooksEntity;

/**
 * 
 * @author matsushitaei 読んだ本とユーザー情報を関連づけるサービス層
 *
 */

public class ReadBooksService {
	@Transactional
	public boolean setReadBooks(ReadBooksEntity readBooksEntity) {
		ReadBooksDaoImpl readBooksDaoImpl = new ReadBooksDaoImpl();
		readBooksDaoImpl.openCurrentSessionwithTransaction();
		if (readBooksDaoImpl.getReadBook(readBooksEntity).size() == 0) {
			readBooksEntity.prePersist();
			readBooksDaoImpl.setReadBooks(readBooksEntity);
			readBooksDaoImpl.closeCurrentSessionwithTransaction();
			return true;
		} else {
			readBooksDaoImpl.closeCurrentSessionwithTransaction();
			return false;
		}
	}

	public boolean updateReadBooks(ReadBooksEntity readBooksEntity) {
		ReadBooksDaoImpl readBooksDaoImpl = new ReadBooksDaoImpl();
		readBooksDaoImpl.openCurrentSessionwithTransaction();
		readBooksEntity.preUpdate();
		readBooksDaoImpl.updateReadBooks(readBooksEntity);
		readBooksDaoImpl.closeCurrentSessionwithTransaction();
		return true;
	}

	public List<ReadBooksEntity> getReadBook(ReadBooksEntity readBooksEntity) {
		ReadBooksDaoImpl readBooksDaoImpl = new ReadBooksDaoImpl();
		readBooksDaoImpl.openCurrentSession();
		List<ReadBooksEntity> readBookList = readBooksDaoImpl.getReadBook(readBooksEntity);
		readBooksDaoImpl.closeCurrentSession();
		return readBookList;
	}

	public List<BooksAndReadBooksDto> getReadBookByUserId(int userId) {
		ReadBooksDaoImpl readBooksDaoImpl = new ReadBooksDaoImpl();
		readBooksDaoImpl.openCurrentSession();
		List<BooksAndReadBooksDto> readBookList = readBooksDaoImpl.getReadBookByUserId(userId);
		readBooksDaoImpl.closeCurrentSession();
		return readBookList;
	}
}
