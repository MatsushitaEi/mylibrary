package jp.co.mylibrary.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author matsushitaei ユーザー情報の格納クラス
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class UsersEntity extends AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Id
	private String mlAddress;

	private String name;

	private String pass;

}
