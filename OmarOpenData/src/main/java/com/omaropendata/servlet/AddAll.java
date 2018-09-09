package com.omaropendata.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omaropendata.entity.Course;
import com.omaropendata.entity.CoursePart;
import com.omaropendata.entity.CourseType;
import com.omaropendata.entity.FunctionType;
import com.omaropendata.entity.Person;
import com.omaropendata.entity.TypeSpecialty;
//import com.omaropendata.utils.JPAutil;
import com.omaropendata.utils.ServletHelper;

/**
 * Servlet implementation class AddAll , to add data to DB
 */
@WebServlet("/AddAll")
public class AddAll extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		 EntityManagerFactory factory;
		  EntityManager entityManager;
		factory =  Persistence.createEntityManagerFactory("OmarOpenData");
		entityManager = factory.createEntityManager();
		final ServletOutputStream out = new ServletHelper().configureAndGetOutputStream(response);
		out.println("Start DAO opretation");
		out.flush();

		// add the person
		Person p=   new Person();
			p.setFirstName("Ahmed");
			List<String> emails =new ArrayList<>();
			emails.add("ahmed@deauphine.eu");
			p.setEmails(emails);
			p.setFax("0583567686");
			p.setLastName("Ali");
			p.setOffice("P30");
			p.setRole(FunctionType.MAITRE_DE_CONFERENCES);
	    Person p1=  new Person();
		    p1.setFirstName("Yassin");
			List<String> emails2 =new ArrayList<>();
			emails2.add("Yassin@deauphine.eu");
			p1.setEmails(emails2);
			p1.setFax("0687964534");
			p1.setLastName("Osman");
			p1.setOffice("P31");
			p1.setRole(FunctionType.ENS_VAC);
	    Person p2=  new Person();
		    p2.setFirstName("Omar");
			List<String> emails3 =new ArrayList<>();
			emails3.add("omar@deauphine.eu");
			p2.setEmails(emails3);
			p2.setFax("0712123456");
			p2.setLastName("Yazen");
			p2.setOffice("P9");
		    p2.setRole(FunctionType.PROFESSEUR_DES_UNIVERSITES);

		// add all the courses int the BDD
	    Course c=   new Course();
		    c.setCourseName("Java");
		    List<CoursePart >  cps= new ArrayList<>();
		    CoursePart cp1 =  new CoursePart(CourseType.TP, 3,p);
		    cps.add(cp1);
		    c.setCoursePart(cps);
		    c.setCredits(3);
		    c.setDescription("Introduction to JPA");
		    c.setLocale(new Locale("1/08/2018"));
		    c.setSpecialty(TypeSpecialty.M1_MIAGE_SITN);
	    Course c1=  new Course();
		    c1.setCourseName("Android");
		    List<CoursePart >  cps1= new ArrayList< >();
		    CoursePart cp11 =  new CoursePart(CourseType.CM, 3,p1);
		    cps1.add(cp11);
		    c1.setCoursePart(cps1);
		    c1.setCredits(3);
		    c1.setDescription("Cours CM pour Android");
		    c1.setLocale(new Locale("03/08/2018"));
		    c1.setSpecialty(TypeSpecialty.M2_MIAGE_SITN);
			
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
		//entityManager.persist(p);
	 	//entityManager.persist(p1);
	 	entityManager.persist(p2);
	 	entityManager.persist(c);
	 	entityManager.persist(c1);
	 	tx.commit();
	 	entityManager.close();
	 	out.println(" Data added , End all operation");
		out.flush();
	}
	
	

}
