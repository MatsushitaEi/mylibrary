/**
 * 
 */
package jp.co.mylibrary.entity;

import javax.persistence.Entity;
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

	@Id
	private int bookId;

	@Id
	private int userId;

	private int readPage;

}
