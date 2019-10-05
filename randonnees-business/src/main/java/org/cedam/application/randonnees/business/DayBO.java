package org.cedam.application.randonnees.business;

import java.util.List;

import org.cedam.application.randonnees.entity.Day;



public interface DayBO {
	
	Day getById(Long id);
	
    List<Day> listDays();
    
    void add(Day day);

  
    
}