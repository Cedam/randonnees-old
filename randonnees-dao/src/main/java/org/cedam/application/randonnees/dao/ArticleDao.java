package org.cedam.application.randonnees.dao;

import java.util.List;

import org.cedam.application.randonnees.entity.Article;

public interface ArticleDao {

	Article getById(Long id);

	List<Article> listArticles();

	void add(Article object);

}
