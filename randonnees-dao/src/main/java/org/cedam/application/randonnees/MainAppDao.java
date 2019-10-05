package org.cedam.application.randonnees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.dao.config.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



@SpringBootApplication
public class MainAppDao {

	private static final Logger logger = LogManager.getLogger(MainAppDao.class);
	
	
	public static void main(String[] args) {
		//SpringApplication.run(MainAppDao.class, args);
	      AnnotationConfigApplicationContext context = 
	              new AnnotationConfigApplicationContext(AppConfig.class);
	      
	      
	      context.close();
	}

}
//
//
//
//private static final Logger logger = LogManager.getLogger(MainAppDao.class);
//
//public static void main(String[] args) {
//	logger.error("MainApp : init");
//	testArticleDao();
//	//oneToMany();
//}
//
//@Transactional
//public static void testArticleDao() {
//	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//	ArticleDao articleDao = context.getBean(ArticleDao.class);
//
//	Article article = context.getBean(Article.class);
//	article.setName("ss");
//	
//	articleDao.add(article);
//	
//	context.close();
//}
//
//
//public static void testOnToMany() {
//	Session session = null;
//	Transaction transaction = null;
//	try {
//		session = HibernateUtil.getSessionFactory().openSession();
//		transaction = session.beginTransaction();
//		// transaction.begin();
//
//		Department department = new Department();
//		department.setName("IT Department2");
//
//		Employee employee1 = new Employee();
//		employee1.setName("Adam");
//		employee1.setDesignation("Manager");
//		employee1.setDepartment(department);
//
//		Employee employee2 = new Employee();
//		employee2.setName("Miller");
//		employee2.setDesignation("Software Engineer");
//		employee2.setDepartment(department);
//
//		Employee employee3 = new Employee();
//		employee3.setName("Smith");
//		employee3.setDesignation("Associate  Engineer");
//		employee3.setDepartment(department);
//
//		// department.getEmployees().add(employee1);
//		// department.getEmployees().add(employee2);
//		// department.getEmployees().add(employee3);
//
//		session.persist(department);
//
//		transaction.commit();
//	} catch (Exception e) {
//		if (transaction != null) {
//			transaction.rollback();
//		}
//		e.printStackTrace();
//	} finally {
//		if (session != null) {
//			session.close();
//		}
//	}
//
//	HibernateUtil.shutdown();
//}
//
//public static void oneToMany() {
//	Session session = null;
//	Transaction transaction = null;
//	try {
//		session = HibernateUtil.getSessionFactory().openSession();
//		transaction = session.beginTransaction();
//		// transaction.begin();
//
//		Department department = new Department();
//		department.setName("IT Department");
//
//		Employee employee1 = new Employee();
//		employee1.setName("Adam");
//		employee1.setDesignation("Manager");
//		employee1.setDepartment(department);
//
//		Employee employee2 = new Employee();
//		employee2.setName("Miller");
//		employee2.setDesignation("Software Engineer");
//		employee2.setDepartment(department);
//
//		Employee employee3 = new Employee();
//		employee3.setName("Smith");
//		employee3.setDesignation("Associate  Engineer");
//		employee3.setDepartment(department);
//
//		department.getEmployees().add(employee1);
//		department.getEmployees().add(employee2);
//		department.getEmployees().add(employee3);
//
//		session.persist(department);
//
//		transaction.commit();
//	} catch (Exception e) {
//		if (transaction != null) {
//			transaction.rollback();
//		}
//		e.printStackTrace();
//	} finally {
//		if (session != null) {
//			session.close();
//		}
//	}
//
//	HibernateUtil.shutdown();
//}