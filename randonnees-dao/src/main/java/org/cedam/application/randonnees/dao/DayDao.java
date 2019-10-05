package org.cedam.application.randonnees.dao;

import java.util.List;

import org.cedam.application.randonnees.entity.Day;

public interface DayDao {

	Day getById(Long id);

	List<Day> listDays();

	void add(Day object);

}
