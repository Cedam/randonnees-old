package org.cedam.application.old;

import org.cedam.application.randonnees.dao.DayV2Dao;
import org.cedam.application.randonnees.entity.DayV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dayV2Business")
public class DayV2Business {

	@Autowired
	private DayV2Dao dayV2Dao;

	public Iterable<DayV2> GetAll() {
		return dayV2Dao.findAll();
	}

	public DayV2 GetById(Long id) {
		return dayV2Dao.findById(id).get();
	}

	public DayV2 save(DayV2 day) {
		dayV2Dao.save(day);
		return dayV2Dao.save(day);
	}

}
