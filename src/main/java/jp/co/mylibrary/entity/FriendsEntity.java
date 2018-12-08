/**
 * 
 */
package jp.co.mylibrary.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author matsushitaei 友達をひもづけるテーブル
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class FriendsEntity extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int userId;

	@Id
	private int friendId;

}
