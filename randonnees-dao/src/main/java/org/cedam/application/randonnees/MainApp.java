package org.cedam.application.randonnees;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.dao.config.AppConfig;
import org.cedam.application.randonnees.dao.utils.HibernateUtil;
import org.cedam.application.randonnees.entity.Department;
import org.cedam.application.randonnees.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author imssbora
 *
 */
public class MainApp {

	private static final Logger logger = LogManager.getLogger(MainApp.class);

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		oneToMany();
		logger.error("MainApp : init");
		// testPersonnePassport();
		// testOnToMany();
	}

	public static void testPersonnePassport() {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//		PersonService personService = context.getBean(PersonService.class);
//		ArticleService articleService = context.getBean(ArticleService.class);
//		PassportService passportService = context.getBean(PassportService.class);
//
//		Person person1 = context.getBean(Person.class);
//		person1.setLastName("aa");
//		person1.setEmail("mail");
//
//		Article article = context.getBean(Article.class);
//		article.setName("ss");
//		person1.getArticles().add(article);
//
//		Passport passport = context.getBean(Passport.class);
//		passport.setValue("aa");
//		passport.setPersonne(person1);
//		passportService.add(passport);
//
//		List<Person> persons = personService.listPersons();
//		for (Person person : persons) {
//			System.out.println("Id = " + person.getId());
//			System.out.println("First Name = " + person.getFirstName());
//			System.out.println("Last Name = " + person.getLastName());
//			System.out.println("Email = " + person.getEmail());
//			System.out.println("Passport = " + person.getPassport());
//			Set<Article> articles = person.getArticles();
//			System.out.println();
//		}
//
//		context.close();
	}

	public static void testOnToMany() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// transaction.begin();

			Department department = new Department();
			department.setName("IT Department2");

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

			// department.getEmployees().add(employee1);
			// department.getEmployees().add(employee2);
			// department.getEmployees().add(employee3);

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
