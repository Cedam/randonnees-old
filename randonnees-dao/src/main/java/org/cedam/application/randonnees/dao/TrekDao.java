package org.cedam.application.randonnees.dao;

import java.util.List;

import org.cedam.application.randonnees.entity.Trek;

public interface TrekDao {

	List<Trek> listTreks();

	Trek getById(Long id);

	void add(Trek object);

}
