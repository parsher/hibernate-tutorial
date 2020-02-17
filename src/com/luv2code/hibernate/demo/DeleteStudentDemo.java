package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			
			// start a transaction
			session.beginTransaction();

			int studentId = 1;
			Student myStudent = session.get(Student.class,studentId);
			
			// delete
			session.delete(myStudent);
			
		
			// commit transaction
			session.getTransaction().commit();
		
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("Delete student id: 2");
			session.createQuery("delete from Student where id = 2").executeUpdate();
			
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
