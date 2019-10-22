package org.cedam.application.randonnees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.business.ArticleBO;
import org.cedam.application.randonnees.business.DayBO;
import org.cedam.application.randonnees.dao.config.AppConfig;
import org.cedam.application.randonnees.dao.utils.HibernateUtil;
import org.cedam.application.randonnees.entity.Article;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Department;
import org.cedam.application.randonnees.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MainAppBO {

	private static final Logger logger = LogManager.getLogger(MainAppBO.class);

	public static void main(String[] args) {
		logger.error("MainApp : init");
		testDaysService();
		//testArticleService();
		//oneToMany();
	}

	public static void testDaysService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		DayBO dayBO = context.getBean(DayBO.class);

		
		dayBO.insert(dayBO.getById((long) 1));
		
		Day day= new Day();
		day.setNumber("cc");
		day.setId(2);
		dayBO.insert(day);
		
		context.close();
	}

	
	public static void testArticleService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		ArticleBO articleBo = context.getBean(ArticleBO.class);

		//Article article = context.getBean(Article.class);
		Article article = new Article();
		
		article.setName("ss");
		articleBo.insert(article);
		
		
		context.close();
	}

	public static void oneToMany() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// transaction.begin();

			Department department = new Department();
			department.setName("IT Department");

			Employee employee1 = new Employee();
			employee1.setName("Adam");
			employee1.setDesignation("Manager");
			employee1.setDepartment(department);

			Employee employee2 = new Employee();
			employee2.setName("Miller");
			employee2.setDesignation("Software Engineer");
			employee2.setDepartment(department);

			Employee employee3 = new Employee();
			employee3.setName("Smith");
			employee3.setDesignation("Associate  Engineer");
			employee3.setDepartment(department);

			department.getEmployees().add(employee1);
			department.getEmployees().add(employee2);
			department.getEmployees().add(employee3);

			session.persist(department);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		HibernateUtil.shutdown();
	}

}
