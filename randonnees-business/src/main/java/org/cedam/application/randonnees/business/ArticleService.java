package org.cedam.application.randonnees.business;

import java.util.List;

import org.cedam.application.randonnees.entity.Article;



public interface ArticleService {
	
	Article getById(Long id);
	
    List<Article> listArticles();
    
    void add(Article article);

  
    
}