package org.cedam.application.randonnees.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.cedam.application.randonnees.dao.TrekDao;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.springframework.stereotype.Repository;


@Repository
public class TrekDaoImp implements TrekDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Trek getById(Long id) {
		return em.find(Trek.class, id);
	}

	@Override
	public List<Trek> listTreks() {
		CriteriaQuery<Trek> criteriaQuery = em.getCriteriaBuilder().createQuery(Trek.class);
		@SuppressWarnings("unused")
		Root<Trek> root = criteriaQuery.from(Trek.class);
		return em.createQuery(criteriaQuery).getResultList();

	}

	@Override
	public void insert(Trek object) {
		em.persist(object);
	}

	@Override
	public long update(Trek object) {
		Trek obj = em.merge(object);
		return obj.getId();
	}
	
}