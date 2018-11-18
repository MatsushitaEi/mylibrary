/**
 * 
 */
package jp.co.mylibrary.entity;

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
public class FriendsEntity extends AbstractEntity {

	@Id
	private int userId;

	@Id
	private int friendId;

}
