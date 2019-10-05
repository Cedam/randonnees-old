package org.cedam.application.randonnees.business.impl;

import java.util.List;

import org.cedam.application.randonnees.business.TrekBO;
import org.cedam.application.randonnees.dao.TrekDao;
import org.cedam.application.randonnees.entity.Trek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrekBOImp implements TrekBO {

	@Autowired
	private TrekDao trekDao;

	@Override
	public Trek getById(Long id) {
		return trekDao.getById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Trek> listTreks() {
		return trekDao.listTreks();
	}
	
	@Transactional
	@Override
	public void add(Trek Trek) {
		trekDao.add(Trek);
	}




}
