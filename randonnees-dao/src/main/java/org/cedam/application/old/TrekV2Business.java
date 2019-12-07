package org.cedam.application.old;

import org.cedam.application.randonnees.dao.TrekV2Dao;
import org.cedam.application.randonnees.entity.DayV2;
import org.cedam.application.randonnees.entity.TrekV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("trekV2Business")
public class TrekV2Business {

	@Autowired
	private TrekV2Dao trekV2Dao;

	@Autowired
	private DayV2Business dayV2Business;

	public Iterable<TrekV2> GetAll() {
		return trekV2Dao.findAll();
	}

	public boolean AddDay(TrekV2 trek, DayV2 day) {
		Boolean result = true;
		day.setTrek(trek);
		day = dayV2Business.save(day);
		return result;
	}

}
