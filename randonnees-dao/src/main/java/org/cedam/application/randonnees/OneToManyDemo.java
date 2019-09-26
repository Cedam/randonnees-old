package org.cedam.application.randonnees;

import org.cedam.application.randonnees.dao.utils.HibernateUtil;
import org.cedam.application.randonnees.entity.Department;
import org.cedam.application.randonnees.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author imssbora
 */
public class OneToManyDemo {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			//transaction.begin();

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
