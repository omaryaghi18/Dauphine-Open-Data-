package com.omaropendata.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omaropendata.dao.PersonDao;
import com.omaropendata.entity.Person;

/**
 * Servlet implementation class AddPersonServlet
 */
public class AddPersonServlet extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String firstName = request.getParameter("pname");
String email = request.getParameter("pemail");
String lastname = request.getParameter("plastname");
String role = request.getParameter("prole");
		
	//	StudentDao dao1 = new StudentDao(); // getting the data from the student dao file by passing the stdid, "good practice" to seperate the db connection/operation code in dao files
	//	Student s1 = dao1.getStudent(stdid); //we store the studentdao in normal Student object then send it to the display,this is the student that the user is waiting to see , after sending the stdid , now we must display this information in a separate jsp file
		Person persontodb = new Person();
		persontodb.setFirstName(firstName);
		persontodb.setLastName(lastname);
		//String dbemail = (String)persontodb.setEmails(email);
		//persontodb.setRole(role);
		
		//System.out.println(persontodb);
		
		//request.setAttribute("Persontodb", persontodb);
		HttpSession session = request.getSession();
		
		session.setAttribute("Persontodb", persontodb);
		response.sendRedirect("PersonDao.java");
		
	
		//RequestDispatcher rd = request.getRequestDispatcher("PersonDao.java");
		//rd.forward(request, response);
	}

	

}
