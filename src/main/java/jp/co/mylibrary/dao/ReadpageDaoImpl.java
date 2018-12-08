package jp.co.mylibrary.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import jp.co.mylibrary.entity.ReadPageEntity;

public class ReadpageDaoImpl extends DaoSupport {

	@Transactional
	public void setReadPage(ReadPageEntity readPageEntity) {
		getCurrentSession().save(readPageEntity);
	}

	@Transactional
	public void updateReadPage(ReadPageEntity readPageEntity) {
		getCurrentSession().update(readPageEntity);
	}

	public List<ReadPageEntity> getReadPageByDate(ReadPageEntity readPageEntity) {
		Criteria criteria = getCurrentSession().createCriteria(ReadPageEntity.class);
		criteria.add(Restrictions.eq("userId", readPageEntity.getUserId()))
				.add(Restrictions.ge("createDate", readPageEntity.getCreateDate()));
		List<ReadPageEntity> readPageEntities = (List<ReadPageEntity>) criteria.list();
		return readPageEntities;
	}
}
