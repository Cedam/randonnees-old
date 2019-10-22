package org.cedam.application.randonnees.business.impl;

import java.util.List;

import org.cedam.application.randonnees.business.ArticleBO;
import org.cedam.application.randonnees.dao.ArticleDao;
import org.cedam.application.randonnees.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleBOImp implements ArticleBO {

	@Autowired
	private ArticleDao articleDao;

	@Transactional
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
	public void insert(Article Article) {
		articleDao.insert(Article);
	}

}
