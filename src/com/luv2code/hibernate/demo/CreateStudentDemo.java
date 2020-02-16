package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
				
	}

}
