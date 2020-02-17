package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			
			// query student;
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			
			// display the students
			theStudents = session.createQuery("from Student s where s.lastName='Deo'").getResultList();
			
			System.out.println("\nThe last name of Doe\n");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Deo' OR s.firstName='Daffy'").getResultList();
			System.out.println("\nThe last name of Doe or Daffy\n");
			displayStudents(theStudents);
			
			
			theStudents = session.createQuery("from Student s where s.email Like '%luv2code.com'").getResultList();
			System.out.println("\nThe email like gmail.com\n");
			displayStudents(theStudents);
			
			
			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
				
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
