package com.omaropendata.servlet;


import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omaropendata.entity.Course;
import com.omaropendata.entity.Person;
import com.omaropendata.utils.JPAutil;


/**
 * Servlet implementation class DeletAll
 */
@WebServlet("/RemoveAll")
public class RemoveAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		 EntityManagerFactory factory;
		  EntityManager entityManager;
		factory =  Persistence.createEntityManagerFactory("OpenDataProject");
		entityManager = factory.createEntityManager();

		 //delete all the course on the BDD
	     List<Course> Courses =entityManager.createQuery("select c from Course c").getResultList();
	     List<Person> Persons =entityManager.createQuery("select p from Person p").getResultList();
		 EntityTransaction tx = entityManager.getTransaction();
	
		 tx.begin();
		 for (Course course : Courses) { 
			 Course  CourseDeleted =entityManager.merge(course); 
		     entityManager.remove(CourseDeleted);   
		}
		 for (Person person : Persons) { 
			 Person  PersonDeleted =entityManager.merge(person); 
		     entityManager.remove(PersonDeleted);   
		}
		 
		 
		 tx.commit();
		 entityManager.close();
	        
	      
	
	}


}
