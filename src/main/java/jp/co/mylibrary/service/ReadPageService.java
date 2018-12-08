package jp.co.mylibrary.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jp.co.mylibrary.dao.ReadpageDaoImpl;
import jp.co.mylibrary.entity.ReadPageEntity;

public class ReadPageService {

	@Transactional
	public void setReadPage(ReadPageEntity readPageEntity) {
		ReadpageDaoImpl readpageDaoImpl = new ReadpageDaoImpl();
		readpageDaoImpl.openCurrentSessionwithTransaction();
		readPageEntity.prePersist();
		readpageDaoImpl.setReadPage(readPageEntity);
		readpageDaoImpl.closeCurrentSessionwithTransaction();
	}

	public List<ReadPageEntity> getReadPageByDate(ReadPageEntity readPageEntity) {
		ReadpageDaoImpl readpageDaoImpl = new ReadpageDaoImpl();
		readpageDaoImpl.openCurrentSession();
		return readpageDaoImpl.getReadPageByDate(readPageEntity);
	}

}
