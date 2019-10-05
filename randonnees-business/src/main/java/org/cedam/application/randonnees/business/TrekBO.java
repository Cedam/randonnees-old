package org.cedam.application.randonnees.business;

import java.util.List;

import org.cedam.application.randonnees.entity.Trek;

public interface TrekBO {

	Trek getById(Long id);

	List<Trek> listTreks();

	void add(Trek object);

}