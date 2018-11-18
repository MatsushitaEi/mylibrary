/**
 * 
 */
package jp.co.mylibrary.dao;

import jp.co.mylibrary.entity.UsersEntity;

/**
 * @author matsushitaei USERテーブルのCRUD操作用Dao
 */
public interface UsersDao {

	public UsersEntity getLoginUser();

	public void setUser();

}
