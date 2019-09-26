package org.cedam.application.randonnees.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.cedam.application.randonnees.dao.ArticleDao;
import org.cedam.application.randonnees.entity.Article;
import org.springframework.stereotype.Repository;

/**
 * @author imssbora
 *
 */
@Repository
public class ArticleDaoImp implements ArticleDao {

   @PersistenceContext
   private EntityManager em;

   @Override
   public Article getById(Long id) {
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
   public void add(Article article) {
      em.persist(article);
   }



}