package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object
			// create a student object
			System.out.println("Creating new student object...");
			String theDateOfBirthStr = "31/12/1998";
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			Student tempStudent = new Student("Daffy", "Duck", theDateOfBirth, "daffy@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();
			
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());

			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student student = session.get(Student.class, tempStudent.getId());
			
			System.out.println(student);
			
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
