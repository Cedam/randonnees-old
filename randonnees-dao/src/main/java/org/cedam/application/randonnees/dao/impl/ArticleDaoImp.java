package org.cedam.application.randonnees.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.dao.ArticleDao;
import org.cedam.application.randonnees.entity.Article;
import org.springframework.stereotype.Repository;


@Repository
public class ArticleDaoImp implements ArticleDao {

	private static final Logger logger = LogManager.getLogger(ArticleDaoImp.class);
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Article getById(Long id) {
		logger.debug("getById : {0}", id);
		return em.find(Article.class, id);
	}

	@Override
	public List<Article> listArticles() {
		CriteriaQuery<Article> criteriaQuery = em.getCriteriaBuilder().createQuery(Article.class);
		@SuppressWarnings("unused")
		Root<Article> root = criteriaQuery.from(Article.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void insert(Article object) {
		em.persist(object);
	}

}