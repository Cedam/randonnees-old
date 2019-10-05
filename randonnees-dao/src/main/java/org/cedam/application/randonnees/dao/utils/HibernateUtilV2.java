package org.cedam.application.randonnees.dao.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilV2 {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			initialize();
		}
		return sessionFactory;
	}

	public static void initialize() {
		Configuration config = new Configuration();
		sessionFactory = config.buildSessionFactory();

		if (sessionFactory == null) {
			throw new IllegalStateException("Le sessionFactory n'a pas été initialisé.");
		}
	}
}