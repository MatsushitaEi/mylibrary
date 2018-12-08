/**
 * 
 */
package jp.co.mylibrary.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author matsushitaei 読んだページ数を格納
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ReadPageEntity extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	private int bookId;

	private int userId;

	private int readPage;

}
