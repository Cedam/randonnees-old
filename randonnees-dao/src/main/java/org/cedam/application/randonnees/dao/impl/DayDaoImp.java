package org.cedam.application.randonnees.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.cedam.application.randonnees.dao.DayDao;
import org.cedam.application.randonnees.entity.Day;
import org.springframework.stereotype.Repository;


@Repository
public class DayDaoImp implements DayDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Day getById(Long id) {
		return em.find(Day.class, id);
	}

	@Override
	public List<Day> listDays() {
		CriteriaQuery<Day> criteriaQuery = em.getCriteriaBuilder().createQuery(Day.class);
		@SuppressWarnings("unused")
		Root<Day> root = criteriaQuery.from(Day.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void insert(Day object) {
		em.persist(object);
	}
	
	@Override
	public long update(Day object) {
		Day obj = em.merge(object);
		//ou 
		//em.flush();
		return obj.getId();
	}


}