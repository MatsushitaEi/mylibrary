/**
 * 
 */
package jp.co.mylibrary.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author matsushitaei 読んでいる本の情報を格納
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ReadBooksEntity extends AbstractEntity {

	@Id
	private int bookId;

	@Id
	private int userId;

	private int endFlg;

	private int readPage;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

}
