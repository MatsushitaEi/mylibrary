package jp.co.mylibrary.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author matsushitaei 書籍情報を格納するエンティティ
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class BooksEntity extends AbstractEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;

	@Id
	private String bookName;

	@Id
	private String author;

	@Id
	private int totalPage;

	private String img;

}
