package org.cedam.application.randonnees.dao.utils;

import java.util.HashMap;
import java.util.Map;

import org.cedam.application.randonnees.entity.Department;
import org.cedam.application.randonnees.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				Map<String, String> settings = new HashMap<String, String>();
				settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
				settings.put("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/randonnees");
				settings.put("hibernate.connection.username", "AdminDCO");
				settings.put("hibernate.connection.password", "AdminDCO");
				settings.put("hibernate.show_sql", "false");
				settings.put("hibernate.hbm2ddl.auto", "update");
				settings.put("hibernate.generate_statistics", "false");
				
				registryBuilder.applySettings(settings);

				registry = registryBuilder.build();

				MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);

				Metadata metadata = sources.getMetadataBuilder().build();

				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				System.out.println("SessionFactory creation failed");
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}