package org.cedam.application.old;

import java.util.List;

import org.cedam.application.randonnees.entity.Trek;

public interface _TrekBO {

	Trek getById(Long id);

	List<Trek> listTreks();

	void insert(Trek object);

	long update(Trek Trek);

}