package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object
			// create 3 student objects
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("John", "Deo", "John@luv2code.com");
			Student tempStudent2 = new Student("Marry", "Public", "Marryl@luv2code.com");
			Student tempStudent3 = new Student("Paul", "Wall", "Paul@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);


			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
