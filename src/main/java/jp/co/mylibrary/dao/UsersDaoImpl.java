/**
 * 
 */
package jp.co.mylibrary.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import jp.co.mylibrary.entity.UsersEntity;

/**
 * @author matsushitaei
 *
 */
public class UsersDaoImpl extends DaoSupport {

	public UsersEntity getLoginUser(String mlAddress) {
		openCurrentSession();
		Criteria criteria = getCurrentSession().createCriteria(UsersEntity.class)
				.add(Restrictions.eq("mlAddress", mlAddress));
		UsersEntity user = (UsersEntity) criteria.uniqueResult();
		return user;
	}

	public void setUser(UsersEntity usersEntity) {
		openCurrentSessionwithTransaction();
		getCurrentSession().save(usersEntity);
	}

}
