package org.cedam.application.old;

import java.util.List;

import org.cedam.application.randonnees.entity.Day;

public interface _DayBO {

	Day getById(Long id);

	List<Day> listDays();

	void insert(Day day);

	long update(Day day);

}