package jp.co.mylibrary.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author matsushitaei BOOKSテーブルとREAD_BOOKSテーブルの２つを結合した結果を保持するテーブル
 *
 */

@Getter
@Setter
public class BooksAndReadBooksDto {

	private int bookId;

	private String bookName;

	private String author;

	private int totalPage;

	private String img;

	private int userId;

	private int readPage;

	private int endFlg;

}
