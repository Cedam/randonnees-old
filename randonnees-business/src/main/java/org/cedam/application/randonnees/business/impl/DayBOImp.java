package org.cedam.application.randonnees.business.impl;

import java.util.List;

import org.cedam.application.randonnees.business.DayBO;
import org.cedam.application.randonnees.dao.DayDao;
import org.cedam.application.randonnees.entity.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DayBOImp implements DayBO {

	@Autowired
	private DayDao dayDao;

	@Transactional
	@Override
	public Day getById(Long id) {
		return dayDao.getById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Day> listDays() {
		return dayDao.listDays();
	}
	
	@Transactional
	@Override
	public void insert(Day day) {
		dayDao.insert(day);
	}

	@Transactional
	@Override
	public long update(Day day) {
		return dayDao.update(day);
	}


}
