package jp.co.mylibrary.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author matsushitaei 作成日や更新日等を自動設定する親クラス
 */

@MappedSuperclass
public class AbstractEntity implements Serializable {

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String createUser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date prcDate;

	private String prcUser;

	@PrePersist
	public void prePersist() {
		// 登録日、更新日を設定
		Date date = new Date();
		createDate = date;
		prcDate = date;
		createUser = "system";
	}

	@PreUpdate
	public void preUpdate() {
		// 更新日を設定
		Date date = new Date();
		prcDate = date;
		createUser = "system";
	}

}
