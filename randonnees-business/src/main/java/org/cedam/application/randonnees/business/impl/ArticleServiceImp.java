package org.cedam.application.randonnees.business.impl;

import java.util.List;

import org.cedam.application.randonnees.business.ArticleService;
import org.cedam.application.randonnees.dao.ArticleDao;
import org.cedam.application.randonnees.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImp implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Override
	public Article getById(Long id) {
		return articleDao.getById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Article> listArticles() {
		return articleDao.listArticles();
	}
	
	@Transactional
	@Override
	public void add(Article Article) {
		articleDao.add(Article);
	}




}
