package jp.co.mylibrary.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * 
 * @author matsushitaei BOOKSテーブルとREAD_BOOKSテーブルの２つを結合した結果を保持するテーブル
 *
 */
@Entity
@Data
public class BooksAndReadBooksDto {

	@Id
	private int bookId;

	private String bookName;

	private String author;

	private int totalPage;

	private String img;

	private int userId;

	private int readPage;

	private int endFlg;

	private int nowReadPage;

}
