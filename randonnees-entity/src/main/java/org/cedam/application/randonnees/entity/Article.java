package org.cedam.application.randonnees.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author imssbora
 */
@Entity
@Table(name = "ARTICLE")
public class Article {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "DPT_ID")
	   private long id;

	   @Column(name = "NAME", nullable = false, unique = false)
	   private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	   
	   
}